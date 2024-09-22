package com.minit88.springsecurity.accountTransaction.controller;

import com.minit88.springsecurity.accountTransaction.entity.AccountTransactions;
import com.minit88.springsecurity.accountTransaction.repsoitory.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam Long id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.findByMember_MemberIdOrderByTransactionAtDesc(id);
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }
}