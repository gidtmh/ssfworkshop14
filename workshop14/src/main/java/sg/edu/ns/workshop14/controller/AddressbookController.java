package sg.edu.ns.workshop14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sg.edu.ns.workshop14.model.Contact;
import sg.edu.ns.workshop14.service.ContactsRedis;

import org.springframework.web.bind.annotation.PathVariable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.ApplicationArguments;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressbookController {
    private static final Logger logger = LoggerFactory.getLogger(AddressbookController.class);
    @Autowired
    ContactsRedis
    private ApplicationArguments applicationArguments;

    @GetMapping("/")
    public String contactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @GetMapping("/getContact/{contactId}")
    public String getContact(Model model, @PathVariable(value="contactId") String contactId) {
        logger.info("contactId > " + contactId);
        ContactsRedis ctc = new ContactsRedis();
        //ctc.getContactById(model, contactId, applicationArguments);     
        return "showContact";
    }

    @PostMapping("/contact")
    public String contactSubmit(@ModelAttribute Contact contact, Model model) {
        logger.info("Name > " + contact.getName());
        logger.info("Email > " + contact.getEmail());
        logger.info("Phone Number > " + contact.getPhoneNumber());
        ContactsRedis ctc = new ContactsRedis();
        //ctc.saveContact(contact, model, applicationArguments);
        return "showContact";
    }
    
}
