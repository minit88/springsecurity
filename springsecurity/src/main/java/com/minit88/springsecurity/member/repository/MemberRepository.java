package com.minit88.springsecurity.member.repository;

import com.minit88.springsecurity.member.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member,Long> {

    List<Member> findByEmail (String email);
    Optional<Member> findByEmailAndPwd(String email, String password);
}
