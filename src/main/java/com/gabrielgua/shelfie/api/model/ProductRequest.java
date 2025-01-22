package com.gabrielgua.shelfie.api.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    @NotBlank
    private String sku;

    @NotBlank
    @Size(min = 5)
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    private String imageUrl;
    private String description;

    private int minimumQuantity;
}