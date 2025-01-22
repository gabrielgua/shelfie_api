package com.gabrielgua.shelfie.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventoryModel {

    private Long id;
    private ProductModel product;
    private boolean active;
    private Integer currentQuantity;
    private Integer minimumQuantity;

    private OffsetDateTime lastUpdated;
}