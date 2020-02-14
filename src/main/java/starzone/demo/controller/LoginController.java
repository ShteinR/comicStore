package starzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import starzone.demo.dao.UserRepository;
import starzone.demo.entity.User;

import java.security.Principal;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home(Principal principal) {
        if (principal != null) {
            Optional<User> user = userRepository.findUserByUserName(principal.getName());
            if (user.get().getRoles().equals("ROLE_ADMIN")) {
                return "redirect:/adminPage";
            }
            return "redirect:/product";
        } else {
            return "/login";
        }
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome user</h1>");

    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome admin</h1>");
    }

}
