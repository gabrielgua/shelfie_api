package com.gabrielgua.shelfie.api.model;

import com.gabrielgua.shelfie.api.validation.annotations.NonZero;
import com.gabrielgua.shelfie.domain.model.MovementType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovementRequest {

    @NotNull
    private Long productId;

    @NotNull
    @NonZero
    private Integer movementQuantity;

    @NotNull
    private MovementType movementType;

    private String remarks;
}