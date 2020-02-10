package starzone.demo.service;

import org.springframework.stereotype.Service;
import starzone.demo.entity.Order;

public interface OrderService {
     Order create(Order order);
}
