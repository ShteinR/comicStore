package starzone.demo.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starzone.demo.dao.OrderDetailDAO;
import starzone.demo.dao.OrdersDAO;
import starzone.demo.entity.Order;
import starzone.demo.entity.OrderDetail;
import starzone.demo.service.OrderDetailService;
import starzone.demo.service.OrderService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersDAO ordersDAO;
    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public Order create(Order order) {
        return ordersDAO.save(order);
    }

    @Override
    public Iterable<Order> findAll() {
        return ordersDAO.findAll();
    }

    @Override
    public Optional<Order> findById(int id) {
        return ordersDAO.findById(id);
    }

    @Override
    public void received(int id) {
        Order order = ordersDAO.findById(id).get();
        order.setStatus(true);
        ordersDAO.save(order);

    }
}
