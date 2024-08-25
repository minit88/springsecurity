package com.minit88.springsecurity.user.repository;

import com.minit88.springsecurity.user.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Member,Long> {

    List<Member> findByEmail (String email);
}
