package com.gabrielgua.shelfie.api.controller;

import com.gabrielgua.shelfie.api.assembler.ProductMapper;
import com.gabrielgua.shelfie.api.model.ProductModel;
import com.gabrielgua.shelfie.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    @GetMapping
    public List<ProductModel> getAll() {
        return mapper.toCollectionModel(service.list());
    }
}