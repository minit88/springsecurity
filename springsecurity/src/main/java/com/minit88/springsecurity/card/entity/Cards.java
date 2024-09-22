package com.minit88.springsecurity.card.entity;

import com.minit88.springsecurity.member.entity.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    private String cardNumber;
    private String cardType;
    private Long totalLimit;
    private Long amountUsed;
    private Long availableAmount;
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="member_id")
    private Member member;
}
