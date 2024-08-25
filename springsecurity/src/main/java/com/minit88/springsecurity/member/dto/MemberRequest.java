package com.minit88.springsecurity.member.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberRequest {
    private String email;
    private String password;
    private String role;

}
