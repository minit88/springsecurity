package com.minit88.springsecurity.accountTransaction.entity;

import com.minit88.springsecurity.account.entity.Accounts;
import com.minit88.springsecurity.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountTransactionId;

    private Long accountNumber;
    private LocalDateTime transactionAt;
    private String transactionSummary;
    private String transactionType;
    private Long transactionAmt;
    private Long closingBalance;
    private LocalDateTime createdAt;

    @ManyToOne(cascade= CascadeType.REMOVE)
    @JoinColumn(name="account_id")
    private Accounts accounts;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="member_id")
    private Member member;
}
