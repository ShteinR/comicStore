package starzone.demo.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starzone.demo.dao.OrderDetailDAO;
import starzone.demo.entity.OrderDetail;
import starzone.demo.service.OrderDetailService;

import javax.transaction.Transactional;

@Service("orderDetailService")
@Transactional
public class OrderDeatailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        return orderDetailDAO.save(orderDetail);
    }

    @Override
    public Iterable<OrderDetail> findAll() {
        return orderDetailDAO.findAll();
    }
}
