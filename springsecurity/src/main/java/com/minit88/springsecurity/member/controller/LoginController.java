package com.minit88.springsecurity.member.controller;

import com.minit88.springsecurity.config.UsernamePwdAuthenticationProvider;
import com.minit88.springsecurity.member.dto.LoginRequestDTO;
import com.minit88.springsecurity.member.dto.LoginResponseDTO;
import com.minit88.springsecurity.member.dto.MemberRequest;
import com.minit88.springsecurity.member.entity.Member;
import com.minit88.springsecurity.member.repository.MemberRepository;
import com.minit88.springsecurity.member.service.MemberService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class LoginController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsernamePwdAuthenticationProvider usernamePwdAuthenticationProvider;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Member member) {
        Member savedMember = null;
        ResponseEntity response = null;
        try {
            String hashPwd = passwordEncoder.encode(member.getPwd());
            member.setPwd(hashPwd);
            member.setCreatedAt(LocalDateTime.now());
            savedMember = customerRepository.save(member);
            if (savedMember.getMemberId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping("/user")
    public Member getUserDetailsAfterLogin(Authentication authentication) {
        List<Member> members = customerRepository.findByEmail(authentication.getName());
        if (members.size() > 0) {
            return members.get(0);
        } else {
            return null;
        }
    }

    @PostMapping("/apiLogin")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        String jwt = "";
        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(loginRequestDTO.username(), loginRequestDTO.password());
        Authentication authenticationResponse = usernamePwdAuthenticationProvider.authenticate(authentication);
        if( null != authenticationResponse && authenticationResponse.isAuthenticated()){
            String secret = Dotenv.load().get("SECRET_KEY");
            SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
            jwt = Jwts.builder().issuer("minit").subject("JWT Token")
                    .claim("username", authenticationResponse.getName())
                    .claim("authorities", authenticationResponse.getAuthorities().stream().map(
                            GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                    .issuedAt(new java.util.Date())
                    .expiration(new java.util.Date((new java.util.Date()).getTime() + 30000000))
                    .signWith(secretKey).compact();

        }
        return ResponseEntity.status(HttpStatus.OK).header("Authorization",jwt)
                .body(new LoginResponseDTO(HttpStatus.OK.getReasonPhrase(), jwt));
    }
}
