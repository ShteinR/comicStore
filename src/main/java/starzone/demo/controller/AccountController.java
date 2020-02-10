package starzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import starzone.demo.entity.User;
import starzone.demo.service.MyUserDetailService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    MyUserDetailService userDetailService;

    @GetMapping()
    private String index() {
        return "account/login";
    }

    @GetMapping("/registration")
    private String signUp() {
        return "account/registration";

    }

    @GetMapping("login")
    private String login(HttpServletRequest request, Model model) {
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        user.setUserPassword(request.getParameter("password"));
        if (user.getUserPassword().equals(request.getParameter("password"))) {
            return "redirect:../cart";
        } else {
            return "redirect:/registration";
        }


    }
}