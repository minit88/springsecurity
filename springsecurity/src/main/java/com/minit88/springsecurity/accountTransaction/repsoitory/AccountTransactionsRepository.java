package com.minit88.springsecurity.accountTransaction.repsoitory;

import com.minit88.springsecurity.accountTransaction.entity.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {

    List<AccountTransactions> findByMember_MemberIdOrderByTransactionAtDesc(Long memberId);

}
