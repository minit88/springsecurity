package com.minit88.springsecurity.card.repository;

import com.minit88.springsecurity.card.entity.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {

    List<Cards> findByMember_MemberId(Long memberId);

}
