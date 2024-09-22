package com.minit88.springsecurity.loan.repository;

import com.minit88.springsecurity.loan.entity.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {

    List<Loans> findByMember_MemberIdOrderByStartAtDesc(Long memberId);

}