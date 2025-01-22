package com.gabrielgua.shelfie.domain.service;

import com.gabrielgua.shelfie.domain.model.Inventory;
import com.gabrielgua.shelfie.domain.model.Movement;
import com.gabrielgua.shelfie.domain.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final MovementRepository repository;
    private final InventoryService inventoryService;

    public Movement save(Movement movement, Inventory inventory) {
        inventoryService.updateCurrentQuantity(inventory, movement.getMovementQuantity());

        return repository.save(movement);
    }

}