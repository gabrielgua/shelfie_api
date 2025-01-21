package com.gabrielgua.shelfie.domain.service;

import com.gabrielgua.shelfie.domain.model.Product;
import com.gabrielgua.shelfie.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> list() {
        return repository.findAll();
    }
}