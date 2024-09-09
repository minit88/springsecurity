package com.minit88.springsecurity.member.service;

import com.minit88.springsecurity.member.dto.MemberRequest;
import com.minit88.springsecurity.member.entity.Member;
import com.minit88.springsecurity.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signUpMember(MemberRequest memberRequest) {
        Optional<Member> existingMember= memberRepository.findByEmailAndPwd(memberRequest.getEmail(), memberRequest.getPassword());
        if (existingMember.isPresent()){
            throw new IllegalArgumentException("Member with email " + memberRequest.getEmail() + " already exists.");
        }
        String hashPwd = passwordEncoder.encode(memberRequest.getPassword());
        Member member = new Member().builder().email(memberRequest.getEmail()).role(memberRequest.getRole()).pwd(hashPwd).build();
        memberRepository.save(member);
    }
}
