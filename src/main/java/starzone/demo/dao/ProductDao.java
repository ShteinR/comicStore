package starzone.demo.dao;

import org.springframework.data.repository.CrudRepository;
import starzone.demo.entity.Product;

public interface ProductDao extends CrudRepository<Product,Integer> {

}
