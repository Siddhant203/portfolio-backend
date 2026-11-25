package com.siddhant.portfolio.controller;

import com.siddhant.portfolio.dto.ContactRequest;
import com.siddhant.portfolio.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @Valid @RequestBody ContactRequest request){
        contactService.saveMessage(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Your message has been sent successfully!!!");
    }
}
