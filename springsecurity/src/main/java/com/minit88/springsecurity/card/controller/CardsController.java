package com.minit88.springsecurity.card.controller;

import com.minit88.springsecurity.card.entity.Cards;
import com.minit88.springsecurity.card.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam Long id) {
        List<Cards> cards = cardsRepository.findByMember_MemberId(id);
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }

}