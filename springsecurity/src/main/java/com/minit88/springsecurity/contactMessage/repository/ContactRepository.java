package com.minit88.springsecurity.contactMessage.repository;

import com.minit88.springsecurity.contactMessage.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
