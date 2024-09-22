package com.minit88.springsecurity.member.entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String name;
    @Column(nullable = false)
    private String email;
    private String mobileNumber;
    private String pwd;
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private String role;
}
