package edu.itstep.mvc.controller;

import edu.itstep.mvc.entity.User;
import edu.itstep.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/askInfo")
    public String askInfoView(Model model) {

        model.addAttribute("user", new User());


        return "ask-info-view";
    }

    @RequestMapping("/showInfo")
    public String showName(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "ask-info-view";
        }
        userRepository.saveOrUpdate(user);
        user.setLastName(user.getLastName().toUpperCase());
        user.setFirstName(user.getFirstName().toUpperCase());
        return "show-info";
    }

}
