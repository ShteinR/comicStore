package starzone.demo.service;

import org.springframework.stereotype.Service;
import starzone.demo.entity.Order;
import starzone.demo.entity.Product;

public interface OrderService {
     Order create(Order order);
      Iterable<Order> findAll();

}
