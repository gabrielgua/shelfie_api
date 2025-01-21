package com.gabrielgua.shelfie.api.assembler;

import com.gabrielgua.shelfie.api.model.ProductModel;
import com.gabrielgua.shelfie.api.model.ProductRequest;
import com.gabrielgua.shelfie.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductModel toModel(Product product) {
        return ProductModel.builder()
                .id(product.getId())
                .sku(product.getSku())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public List<ProductModel> toCollectionModel(List<Product> products) {
        return products.stream()
                .map(this::toModel)
                .toList();
    }

    public Product toEntity(ProductRequest request) {
        var product = new Product();
        product.setSku(request.getSku());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setImageUrl(request.getImageUrl());
        product.setDescription(request.getDescription());
        return product;
    }
}