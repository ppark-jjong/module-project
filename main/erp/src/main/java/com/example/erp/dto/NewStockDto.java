package com.example.erp.dto;

import com.example.erp.entity.NewStock;
import com.example.erp.entity.Product;
import com.example.erp.entity.Storage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewStockDto {
    private long stockId;
    private long storageId;
    private long productId;
    private int count;

    public void toNewStockDto(NewStock newStock) {
        this.stockId = newStock.getStockId();
        this.storageId = newStock.getStorage().getStorageId();
        this.productId = newStock.getProduct().getProductId();
        this.count = newStock.getCount();
    }


    public NewStock toEntity(Storage storage, Product product) {
        return NewStock.builder()
                .storage(storage)
                .product(product)
                .count(count)
                .build();
    }
}

