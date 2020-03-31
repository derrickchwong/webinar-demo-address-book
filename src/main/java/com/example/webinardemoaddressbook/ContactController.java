package com.example.webinardemoaddressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @PostMapping("/contact")
    public Contact createNewContact(@RequestBody Contact contact){
        Assert.notNull(contact.getAddress(), "Address cannot be empty");
        return contactRepository.save(contact);
    }

    @GetMapping("/contact/{id}")
    public Contact getContactById(@PathVariable Long id ){
        return contactRepository.getOne(id);
    }
}
