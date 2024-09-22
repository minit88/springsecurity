package com.minit88.springsecurity.account.repository;



import com.minit88.springsecurity.account.entity.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {

    Accounts findByMember_MemberId(Long memberId);

}