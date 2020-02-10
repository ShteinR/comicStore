package starzone.demo.service;

import starzone.demo.entity.Product;

import java.util.Optional;

public interface ProductService  {
    public Iterable<Product> findAll();
    public Optional<Product> findById(int id);
}
