package com.minit88.springsecurity.contactMessage.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class contactMessages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactMessageId;
    private String contactName;
    @Column(nullable = false)
    private String contactEmail;
    private String subject;
    private String message;
    private LocalDateTime createdAt;
}
