package starzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import starzone.demo.service.OrderService;
import starzone.demo.service.implementations.ProductServiceImpl;

@Controller
@RequestMapping("/adminPage")
public class AdminController {

    @Autowired
    ProductServiceImpl productService;
@Autowired
    OrderService orderService;
   /* @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "adminPage/index";
    }*/
    @GetMapping()
    public String index1(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "adminPage/index";
    }


}
