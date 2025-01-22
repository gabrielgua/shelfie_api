package com.gabrielgua.shelfie.api.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductUpdate {

    private String sku;

    @Size(min = 5)
    private String name;
    private String description;
    private String imageUrl;

    @Positive
    private BigDecimal price;
}