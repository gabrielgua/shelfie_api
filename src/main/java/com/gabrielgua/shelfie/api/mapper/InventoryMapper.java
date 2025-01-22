package com.gabrielgua.shelfie.api.mapper;

import com.gabrielgua.shelfie.api.model.InventoryModel;
import com.gabrielgua.shelfie.api.model.ProductModel;
import com.gabrielgua.shelfie.domain.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {


    public InventoryModel toModelShort(Inventory inventory) {
        return InventoryModel.builder()
                .active(inventory.getActive())
                .currentQuantity(inventory.getCurrentQuantity())
                .minimumQuantity(inventory.getMinimumQuantity())
                .lastUpdated(inventory.getLastUpdated())
                .build();
    }

    public InventoryModel toModel(Inventory inventory) {
        var productModel = ProductModel.builder()
                .id(inventory.getProduct().getId())
                .sku(inventory.getProduct().getSku())
                .name(inventory.getProduct().getName())
                .build();

        return InventoryModel.builder()
                .id(inventory.getId())
                .active(inventory.getActive())
                .lastUpdated(inventory.getLastUpdated())
                .currentQuantity(inventory.getCurrentQuantity())
                .minimumQuantity(inventory.getMinimumQuantity())
                .product(productModel)
                .build();
    }

}