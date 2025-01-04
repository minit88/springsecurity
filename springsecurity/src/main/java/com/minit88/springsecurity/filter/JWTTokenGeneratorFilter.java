package com.minit88.springsecurity.filter;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
    public Dotenv dotenv = Dotenv.load();
    private String secret = dotenv.get("SECRET_KEY");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (null != authentication){
                SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
                String jwt = Jwts.builder().issuer("minit").subject("JWT Token")
                        .claim("username", authentication.getAuthorities().stream().map(
                                GrantedAuthority::getAuthority
                        ).collect(Collectors.joining(","))
                        ).claim("authorities", authentication.getAuthorities().stream().map(
                                GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                        .issuedAt(new Date())
                        .expiration(new Date((new Date()).getTime() + 30000000))
                        .signWith(secretKey).compact();
                response.setHeader("Authorization", jwt);
               filterChain.doFilter(request, response);
            }
        }catch (Exception e){
            throw new InternalError(e.getMessage());
        }
    }

    /**
     * - 특정 요청(request)에 대해 필터가 동작할지 여부를 결정하는 메서드이다.
     * - shouldNotFilter 메서드는 특정 조건에서 필터를 건너뛰도록 설정할 때 사용된다.
     * - true : 해당 요청에 대해 필터를 적용하지 않음
     * - false : 필터를 적용
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/login"); // path가 "/user" 이 아니면 필터 적용 x -> 로그인 시에만 필터 적용
    }

}
