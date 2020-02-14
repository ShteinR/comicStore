package starzone.demo.service;

import starzone.demo.entity.OrderDetail;
import starzone.demo.entity.Product;

public interface OrderDetailService  {
    OrderDetail create(OrderDetail orderDetail);
     Iterable<OrderDetail> findAll();

}
