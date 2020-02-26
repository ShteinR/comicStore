package starzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import starzone.demo.entity.Order;
import starzone.demo.entity.User;
import starzone.demo.service.OrderDetailService;
import starzone.demo.service.OrderService;
import starzone.demo.service.implementations.MyUserDetailService;
import starzone.demo.service.implementations.ProductServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

    @Autowired
    ProductServiceImpl productService;
    @Autowired
    OrderService orderService;
    @Autowired
    MyUserDetailService userDetailService;
    @Autowired
    OrderDetailService orderDetailService;

    /* @GetMapping()
     public String index(Model model) {
         model.addAttribute("products", productService.findAll());
         return "adminPage/index";
     }*/
    @GetMapping()
    public String index1(Model model, HttpSession session) {
        model.addAttribute("orders", orderService.findAll());
        session.setAttribute("users", userDetailService.findAll());
        return "adminPage/index";
    }

    @GetMapping("/usersControl")
    public String control(Model model) {
        model.addAttribute("users", userDetailService.findAll());
        return "adminPage/usersControl";
    }

    @GetMapping("remove/{id}")
    public String remove(Model model, @PathVariable("id") int id) {
        if (orderService.findAll() != null) {
            List<Order> orders = (List<Order>) orderService.findAll();
            if (orderService.findById(id).isPresent()) {
                orderService.received(id);
                model.addAttribute("orders", orders);
            }
            return "adminPage/index";
        }
        return "redirect:/login";
    }

    @GetMapping("/block/{id}")
    public String block(HttpSession session, @PathVariable("id") int id) {
        if (session.getAttribute("users") != null) {
            List<User> users = (List<User>) session.getAttribute("users");
            if (userDetailService.findById(id).isPresent()) {
                userDetailService.changeAccessModifier(id);
                session.setAttribute("users", users);
                return "redirect:/adminPage";
            }
            return "redirect:";
        } else {
            return "redirect:/product";
        }
    }

    @GetMapping("/details/{id}")
    public String details(Model model, @PathVariable("id") int id) {
        if (orderService.findAll() != null) {
            if (orderService.findById(id).isPresent()) {
                List<Order> orders = (List<Order>) orderService.findAll();
                model.addAttribute("orderDetails", orderService.findById(id).get().getOrderDetails());
                return "adminPage/orderDetails";
            }
            return "redirect:";
        } else {
            return "redirect:/product";
        }
    }
}
