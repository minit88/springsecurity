package com.minit88.springsecurity.contactMessage.controller;

import com.minit88.springsecurity.contactMessage.entity.Contact;
import com.minit88.springsecurity.contactMessage.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class ContactController {
    /*
    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactMessageId(getServiceReqNumber());
        contact.setCreateAt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ranNum;
    }

     */
}