package com.example.service.impl;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Product save(Product entity) {
        log.info("Saving product: {}", entity.getName());
        return repository.save(entity);
    }

    @Override
    public List<Product> findAll() {
        log.info("Fetching all products");
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        log.info("Fetching product by id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting product with id: {}", id);
        repository.deleteById(id);
    }
}
