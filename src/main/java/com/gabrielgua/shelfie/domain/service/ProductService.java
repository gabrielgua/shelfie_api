package com.gabrielgua.shelfie.domain.service;

import com.gabrielgua.shelfie.domain.model.Inventory;
import com.gabrielgua.shelfie.domain.model.Movement;
import com.gabrielgua.shelfie.domain.model.Product;
import com.gabrielgua.shelfie.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @Transactional(readOnly = true)
    public List<Product> list() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long productId) {
        return repository.findById(productId).orElseThrow(() -> new RuntimeException("Not found for id"));
    }

    @Transactional(readOnly = true)
    public Product findBySku(String productSku) {
        return repository.findBySku(productSku).orElseThrow(() -> new RuntimeException("Not found for sku"));
    }



    @Transactional
    public Product save(Product product) {
        return repository.save(product);
    }

    @Transactional
    public void delete(Product product) {
        repository.delete(product);
    }
}