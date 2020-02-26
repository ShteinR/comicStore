package starzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import starzone.demo.entity.Product;
import starzone.demo.service.implementations.ProductServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/add")
public class AddController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping()
    public String add(Model model) {

        model.addAttribute("comics", new Product());
        return "/add";

    }

    @PostMapping(name = "/add")
    public String addProduct(@ModelAttribute("comics") Product product, Model model) {
        List<Product> products = productService.findAll();
        for (Product product1 : products) {
            if (product1.getAuthor().getAuthorName().equals(product.getAuthor().getAuthorName())) {
                product.setAuthor(product1.getAuthor());
                break;
            }

        }

        for (Product product1 : products) {
            if (product1.getArtist().getArtistName().equals(product.getArtist().getArtistName())) {
                product.setArtist(product1.getArtist());
                break;
            }
        }

        if (!productService.saveProduct(product)) {
            model.addAttribute("comics", "comics already exist");
            return "/product";
        }


        return "redirect:/product";
    }

}
