package com.minit88.springsecurity.noticeDetails.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class noticeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    private Long accountNumber;
    private String noticeSummary;
    private String noticeDetails;
    private LocalDateTime noticeBegAt;
    private LocalDateTime noticeEndAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
