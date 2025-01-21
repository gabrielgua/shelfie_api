package com.gabrielgua.shelfie.api.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    @NotBlank
    private String sku;

    @Min(5)
    @NotBlank
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    private String imageUrl;
    private String description;
}