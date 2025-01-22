package com.gabrielgua.shelfie.api.controller;

import com.gabrielgua.shelfie.api.mapper.ProductMapper;
import com.gabrielgua.shelfie.api.mapper.UpdateMapper;
import com.gabrielgua.shelfie.api.model.ProductModel;
import com.gabrielgua.shelfie.api.model.ProductRequest;
import com.gabrielgua.shelfie.api.model.ProductUpdate;
import com.gabrielgua.shelfie.domain.service.InventoryService;
import com.gabrielgua.shelfie.domain.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final UpdateMapper updateMapper;
    private final InventoryService inventoryService;
    private final ProductMapper mapper;

    @GetMapping
    public List<ProductModel> getAll() {
        return mapper.toCollectionModel(productService.list());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductModel create(@Valid @RequestBody ProductRequest request) {
        var product = mapper.toEntity(request);
        var inventory = inventoryService.save(productService.save(product), request.getMinimumQuantity());
        product.setInventory(inventory);

        return mapper.toModel(product);
    }

    @PutMapping("/{productId}")
    public ProductModel update(@PathVariable Long productId, @Valid @RequestBody ProductUpdate update) {
        var product = productService.findById(productId);
        updateMapper.copyNonNullProperties(update, product);

        return mapper.toModel(productService.save(product));
    }
}