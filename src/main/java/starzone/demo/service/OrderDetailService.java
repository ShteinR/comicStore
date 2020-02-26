package starzone.demo.service;

import org.aspectj.weaver.ast.Or;
import starzone.demo.entity.OrderDetail;
import starzone.demo.entity.Product;

import java.util.Collection;

public interface OrderDetailService {
    OrderDetail create(OrderDetail orderDetail);

    void deleteAll(Collection<OrderDetail> orderDetails);

    Iterable<OrderDetail> findAll();

    void delete(OrderDetail orderDetail);
}
