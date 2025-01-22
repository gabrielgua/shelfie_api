package com.gabrielgua.shelfie.api.controller;

import com.gabrielgua.shelfie.api.mapper.MovementMapper;
import com.gabrielgua.shelfie.api.model.MovementModel;
import com.gabrielgua.shelfie.api.model.MovementRequest;
import com.gabrielgua.shelfie.domain.service.MovementService;
import com.gabrielgua.shelfie.domain.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movements")
public class MovementController {

    private final ProductService productService;
    private final MovementMapper movementMapper;
    private final MovementService movementService;


    @PostMapping
    public MovementModel save(@Valid @RequestBody MovementRequest request) {
        var product = productService.findById(request.getProductId());

        var movement = movementMapper.toEntity(request);
        movement.setProduct(product);

        return movementMapper.toModel(movementService.save(movement, product.getInventory()));
    }
}