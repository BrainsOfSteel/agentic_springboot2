package com.example.service;

import com.example.entity.Product;
import java.util.List;

public interface ProductService {
    Product save(Product entity);
    List<Product> findAll();
    Product findById(Long id);
    void delete(Long id);
}
