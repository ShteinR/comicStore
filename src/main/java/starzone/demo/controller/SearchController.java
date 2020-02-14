package starzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import starzone.demo.entity.Author;
import starzone.demo.entity.Product;
import starzone.demo.entity.User;
import starzone.demo.service.AuthorService;
import starzone.demo.service.implementations.AuthorServiceImpl;
import starzone.demo.service.implementations.ProductServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    AuthorService authorService;

/*
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("author", new Author());
        return "search/find";
    }
*/

    @GetMapping(name = "/find/{id}")
    public String find(Model model, @PathVariable("id") int id, HttpSession session) {
        if (authorService.getById(id).isPresent()) {
            List<Product> comics = authorService.getById(id).get().getComics();
            model.addAttribute("comics", comics);
        }
        return "redirect:/index";
    }
}
