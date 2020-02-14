package starzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import starzone.demo.service.implementations.MyUserDetailService;
import starzone.demo.entity.User;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    MyUserDetailService userDetailService;

    @GetMapping(name = "/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "/registration";
    }

    @PostMapping(name = "/registration")
    public String addUser(@ModelAttribute("userForm") User user, Model model) {
        try {
            if (!userDetailService.saveUser(user)) {
                model.addAttribute("userForm", "user already exist");
                return "redirect:/login";
            }
            return "redirect:/product";
        } catch (Exception e) {
            return "redirect:/";
        }
    }


}
