package starzone.demo.dao;

import org.springframework.data.repository.CrudRepository;
import starzone.demo.entity.Order;

public interface OrdersDAO  extends CrudRepository<Order,Integer> {
}
