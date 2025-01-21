package com.gabrielgua.shelfie.domain.service;

import com.gabrielgua.shelfie.domain.model.Inventory;
import com.gabrielgua.shelfie.domain.model.Product;
import com.gabrielgua.shelfie.domain.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;


    public Inventory save(Product product) {
        var inventory = new Inventory();
        inventory.setActive(false);
        inventory.setProduct(product);

        return repository.save(inventory);
    }
}