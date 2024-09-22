package com.minit88.springsecurity.member.controller;

import com.minit88.springsecurity.member.dto.MemberRequest;
import com.minit88.springsecurity.member.entity.Member;
import com.minit88.springsecurity.member.repository.MemberRepository;
import com.minit88.springsecurity.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
}
