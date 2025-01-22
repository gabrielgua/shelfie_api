package com.gabrielgua.shelfie.domain.service;

import com.gabrielgua.shelfie.domain.model.Inventory;
import com.gabrielgua.shelfie.domain.model.Movement;
import com.gabrielgua.shelfie.domain.model.Product;
import com.gabrielgua.shelfie.domain.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;


    @Transactional
    public Inventory save(Product product, int minimumQuantity) {
        var inventory = new Inventory();
        inventory.setActive(false);
        inventory.setProduct(product);
        inventory.setMinimumQuantity(minimumQuantity);

        return repository.save(inventory);
    }

    @Transactional
    public void updateCurrentQuantity(Inventory inventory, Integer quantity) {
        var newQuantity = inventory.getCurrentQuantity() + quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Cannot have a negative inventory quantity");
        }

        inventory.setCurrentQuantity(newQuantity);
        repository.save(inventory);
    }
}