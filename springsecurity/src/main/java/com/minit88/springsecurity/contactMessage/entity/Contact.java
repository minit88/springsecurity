package com.minit88.springsecurity.contactMessage.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long contactMessageId;
    private String contactName;
    @Column(nullable = false)
    private String contactEmail;
    private String subject;
    private String message;
    private LocalDateTime createdAt;
}
