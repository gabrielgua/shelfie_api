package com.gabrielgua.shelfie.api.assembler;

import com.gabrielgua.shelfie.api.model.ProductModel;
import com.gabrielgua.shelfie.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductModel toModel(Product product) {
        return ProductModel.builder()
                .id(product.getId())
                .sku(product.getSku())
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
}