package edu.itstep.phonebook.controller;

import edu.itstep.phonebook.entity.Contact;
import edu.itstep.phonebook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping("/")
    public String showAll(Model model) {
        List<Contact> contacts = contactRepository.getAll();
        model.addAttribute("contacts", contacts);
        return "all-contacts";
    }

    @RequestMapping("/createContact")
    public String createContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @RequestMapping("/saveContact")
    public String createContact(@ModelAttribute("contact") Contact contact) {
        contactRepository.saveOrUpdate(contact);
        return "redirect:/";
    }
}
