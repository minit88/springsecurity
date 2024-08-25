package com.minit88.springsecurity.member.controller;

import com.minit88.springsecurity.member.dto.MemberRequest;
import com.minit88.springsecurity.member.entity.Member;
import com.minit88.springsecurity.member.repository.MemberRepository;
import com.minit88.springsecurity.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private MemberService memberService;

    /*
    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

     */

    @PostMapping("/signUp")
    public ResponseEntity<Void> signUp(@RequestBody MemberRequest memberRequest){
        memberService.signUpMember(memberRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
