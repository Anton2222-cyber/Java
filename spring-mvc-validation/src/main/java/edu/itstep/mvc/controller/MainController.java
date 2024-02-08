package edu.itstep.mvc.controller;

import edu.itstep.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MainController {
    @RequestMapping("/")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/askInfo")
    public String askInfoView(Model model) {
        model.addAttribute("user", new User("Ivan", "Ivanov"));
        return "ask-info-view";
    }

    @RequestMapping("/showInfo")
    public String showName(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ask-info-view";
        }
        user.setFirstName(user.getFirstName().toUpperCase());
        user.setLastName(user.getLastName().toUpperCase());
        return "show-info";
    }
}
