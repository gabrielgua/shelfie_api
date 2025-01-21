package com.gabrielgua.shelfie.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gabrielgua.shelfie.domain.model.MovementType;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovementModel {

    private Long id;
    private ProductModel product;
    private int movementQuantity;
    private MovementType movementType;
    private OffsetDateTime movementDate;
    private String remarks;

}