package starzone.demo.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starzone.demo.dao.ProductDao;
import starzone.demo.entity.Product;
import starzone.demo.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();

    }

    public boolean saveProduct(Product product) {
        productDao.save(product);
        return true;
    }

    @Override
    public Optional<Product> findById(int id) {
        return productDao.findById(id);
    }
}
