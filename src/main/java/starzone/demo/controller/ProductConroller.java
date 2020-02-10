package starzone.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import starzone.demo.entity.Product;
import starzone.demo.entity.User;
import starzone.demo.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductConroller {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/index";
    }



}
