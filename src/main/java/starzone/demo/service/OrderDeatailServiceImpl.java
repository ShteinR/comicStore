package starzone.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starzone.demo.dao.OrderDetailDAO;
import starzone.demo.entity.OrderDetail;

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
}
