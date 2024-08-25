package com.minit88.springsecurity.user.entity;

import com.minit88.springsecurity.common.audit.CommonEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class User  extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
}
