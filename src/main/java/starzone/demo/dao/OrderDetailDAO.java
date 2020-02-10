package starzone.demo.dao;

import org.springframework.data.repository.CrudRepository;
import starzone.demo.entity.OrderDetail;

public interface OrderDetailDAO extends CrudRepository<OrderDetail,Integer> {

}
