package com.siddhant.portfolio.service;

import com.siddhant.portfolio.dto.ContactRequest;
import com.siddhant.portfolio.entity.ContactMessage;
import com.siddhant.portfolio.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    public void saveMessage(ContactRequest request){
        ContactMessage contactMessage = new ContactMessage();

        contactMessage.setName(request.getName());
        contactMessage.setEmail(request.getEmail());
        contactMessage.setSubject(request.getSubject());
        contactMessage.setMessage(request.getMessage());

        contactRepository.save(contactMessage);
    }
}
