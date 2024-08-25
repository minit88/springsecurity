package com.minit88.springsecurity.config;

import com.minit88.springsecurity.member.entity.Member;
import com.minit88.springsecurity.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetails implements UserDetailsService {
    /*
    - UserDetailsService는 Spring Security에서 사용자 인증 정보를 제공하기 위해 사용되는 핵심 인터페이스
    - userName을 기반으로 사용자의 상세정보를 로드하는 역할을 한다.
     */
    @Autowired
    MemberRepository memberRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorities = null;
        List<Member> members = memberRepository.findByEmail(username);
        if(members.size()==0){
            System.out.println("User not found");
            throw new UsernameNotFoundException(username);
        }else{
            userName = members.get(0).getEmail();
            password = members.get(0).getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(members.get(0).getRole()));
        }
        return new User(userName,password,authorities);
    }
}
