package starzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import starzone.demo.dao.UserRepository;
import starzone.demo.entity.*;
import starzone.demo.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    MyUserDetailService userDetailService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public String index(HttpSession session, Model model) {
        model.addAttribute("total", summary(session));
        return "cart/index";
    }


    @GetMapping("buy/{id}")
    public String buy(@PathVariable("id") int id, Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<>();
            if (productService.findById(id).isPresent()) {
                cart.add(new Item(productService.findById(id).get(), 1));
                httpSession.setAttribute("cart", cart);
            }
        } else {
            List<Item> cart = (List<Item>) httpSession.getAttribute("cart");
            int index = exist(id, cart);
            if (index == -1) {
                cart.add(new Item(productService.findById(id).get(), 1));

            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            httpSession.setAttribute("cart", cart);
        }
        return "redirect:../../cart";
    }

    @GetMapping("/checkout")
    private String checkout(HttpSession session, Principal principal) {

        if (principal != null) {
            Optional<User> user = userRepository.findUserByUserName(principal.getName());
            Order order = new Order();
            order.setStatus(true);
            order.setName("new Order");
            int orderId = orderService.create(order).getId();
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            for (Item item : cart) {

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(orderId);
                orderDetail.setUser(user.get());
                orderDetail.setPrice((int) item.getProduct().get().getPrice());
                orderDetail.setQuantity(item.getQuantity());
                orderDetail.setOrder(order);
                orderDetail.setProduct(item.getProduct().get());
                orderDetailService.create(orderDetail);
            }
            session.removeAttribute("cart");
            return "redirect:../product";
        } else {
            return "redirect:../login";
        }

    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id, HttpSession session) {

        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = exist(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:../../cart";

    }

    @PostMapping("/update")
    public String update(HttpSession session, HttpServletRequest request) {
        String[] quantities = request.getParameterValues("quantity");
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
        }
        session.setAttribute("cart", cart);
        return "redirect:../cart";
    }

    private int exist(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().get().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private double summary(HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        double sum = 0;
        for (Item item : cart) {
            sum += item.getQuantity() * item.getProduct().get().getPrice();
        }
        return sum;

    }
}
