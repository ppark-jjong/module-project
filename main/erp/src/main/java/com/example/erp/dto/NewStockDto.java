package com.example.erp.dto;

import com.example.erp.entity.NewStock;
import com.example.erp.entity.Product;
import com.example.erp.entity.Storage;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewStockDto {
    private long stockId;
    private long storageId;
    private long productId;
    private int count;
    private Date stockDate;

    public NewStockDto(NewStock newStock) {
    }

    @Builder
    public void toDto(NewStock newStock) {
        this.stockId = newStock.getStockId();
        this.storageId = newStock.getStorage().getStorageId();
        this.productId = newStock.getProduct().getProductId();
        this.count = newStock.getCount();
        this.stockDate = newStock.getStockDate();
    }


    public NewStock toEntity(Storage storage, Product product) {
        return NewStock.builder()
                .storage(storage)
                .product(product)
                .count(count)
                .stockDate(stockDate)
                .build();
    }
}

