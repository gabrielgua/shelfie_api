package com.gabrielgua.shelfie.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventoryModel {

    private Long id;
    private ProductModel product;
    private boolean active;
    private int currentQuantity;
    private int minimumQuantity;

    private OffsetDateTime lastUpdated;
}