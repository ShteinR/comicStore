package starzone.demo.service;

import org.springframework.stereotype.Service;
import starzone.demo.entity.Order;
import starzone.demo.entity.Product;

import java.util.Optional;

public interface OrderService {
     Order create(Order order);
      Iterable<Order> findAll();
    Optional<Order> findById(int id);
    void received(int id);

}
