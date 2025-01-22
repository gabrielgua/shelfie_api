package com.gabrielgua.shelfie.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductModel {

    private Long id;
    private String sku;
    private String name;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private InventoryModel inventory;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}