package com.minit88.springsecurity.account.controller;

import com.minit88.springsecurity.account.entity.Accounts;
import com.minit88.springsecurity.account.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam Long id) {
        Accounts accounts = accountsRepository.findByMember_MemberId(id);
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }

}
