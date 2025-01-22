package com.gabrielgua.shelfie.api.mapper;

import com.gabrielgua.shelfie.api.model.MovementModel;
import com.gabrielgua.shelfie.api.model.MovementRequest;
import com.gabrielgua.shelfie.api.model.ProductModel;
import com.gabrielgua.shelfie.domain.model.Movement;
import org.springframework.stereotype.Component;

@Component
public class MovementMapper {

    public MovementModel toModel(Movement movement) {
        var productModel = ProductModel.builder()
                .id(movement.getProduct().getId())
                .build();

        return MovementModel.builder()
                .id(movement.getId())
                .movementQuantity(movement.getMovementQuantity())
                .movementType(movement.getMovementType())
                .movementDate(movement.getMovementDate())
                .product(productModel)
                .remarks(movement.getRemarks())
                .build();
    }

    public Movement toEntity(MovementRequest request) {
        var movement = new Movement();
        movement.setMovementQuantity(request.getMovementQuantity());
        movement.setMovementType(request.getMovementType());
        movement.setRemarks(request.getRemarks());

        return movement;
    }
}