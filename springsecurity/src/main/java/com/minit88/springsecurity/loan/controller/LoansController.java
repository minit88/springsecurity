package com.minit88.springsecurity.loan.controller;

import com.minit88.springsecurity.loan.entity.Loans;
import com.minit88.springsecurity.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam Long id) {
        List<Loans> loans = loanRepository.findByMember_MemberIdOrderByStartAtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }

}