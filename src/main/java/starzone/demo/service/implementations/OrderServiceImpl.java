package starzone.demo.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starzone.demo.dao.OrdersDAO;
import starzone.demo.entity.Order;
import starzone.demo.service.OrderService;

import javax.transaction.Transactional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersDAO ordersDAO;

    @Override
    public Order create(Order order) {
        return ordersDAO.save(order);
    }

    @Override
    public Iterable<Order> findAll() {
        return ordersDAO.findAll();
    }
}
