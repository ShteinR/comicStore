package starzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import starzone.demo.entity.Product;
import starzone.demo.service.ArtistService;
import starzone.demo.service.AuthorService;
import starzone.demo.service.implementations.ProductServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductConroller {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    AuthorService authorService;
@Autowired
    ArtistService artistService;
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/index";
    }

    @GetMapping("/find/{id}")
    public String find(Model model, @PathVariable("id") int id, HttpSession session) {
        if (authorService.getById(id).isPresent()) {
            List<Product> comics = authorService.getById(id).get().getComics();
            model.addAttribute("comics", comics);
            return "product/productsByAuthor";
        } else {
            return "product/index";
        }
    }
    @GetMapping("/findByArtist/{id}")
    public String findByArtist(Model model, @PathVariable("id") int id, HttpSession session) {
        if (artistService.findById(id).isPresent()) {
            List<Product> comics = artistService.findById(id).get().getComics();
            model.addAttribute("comics", comics);
            return "product/productsByArtist";
        } else {
            return "product/index";
        }
    }


}
