package com.gabrielgua.shelfie.api.controller;

import com.gabrielgua.shelfie.api.assembler.ProductMapper;
import com.gabrielgua.shelfie.api.model.ProductModel;
import com.gabrielgua.shelfie.api.model.ProductRequest;
import com.gabrielgua.shelfie.domain.service.InventoryService;
import com.gabrielgua.shelfie.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final InventoryService inventoryService;
    private final ProductMapper mapper;

    @GetMapping
    public List<ProductModel> getAll() {
        return mapper.toCollectionModel(productService.list());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductModel create(@RequestBody ProductRequest request) {
        var product = mapper.toEntity(request);
        var inventory = inventoryService.save(productService.save(product));
        product.setInventory(inventory);

        return mapper.toModel(product);
    }

}