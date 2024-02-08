package edu.itstep.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @RequestMapping("/")
    public String homePage(){
        return "home";
    }

    @RequestMapping("/askName")
    public String askName(){
        return "ask-name";
    }

    @RequestMapping("/showName")
    public String showName(Model model, @RequestParam("userName") String firstName){
        System.out.println(firstName);
        model.addAttribute("name",firstName.toUpperCase());
        return "show-name";
    }

    @RequestMapping("/registration")
    public String askForm() {
        return "registration";
    }

    @RequestMapping(value = "/showProfile", method = RequestMethod.POST)
    public String showProfile(Model model,
                              @RequestParam("userName") String firstName,
                              @RequestParam("userSurname") String userSurname,
                              @RequestParam("userPatronymic") String userPatronymic,
                              @RequestParam("userBirthYear") String userBirthYear,
                              @RequestParam("userLocation") String userLocation) {
        // You can do further processing with the received parameters
        // For now, just forwarding them to the view
        model.addAttribute("name", firstName);
        model.addAttribute("surname", userSurname);
        model.addAttribute("patronymic", userPatronymic);
        model.addAttribute("birthYear", userBirthYear);
        model.addAttribute("location", userLocation);


        return "show-profile";
    }

}
