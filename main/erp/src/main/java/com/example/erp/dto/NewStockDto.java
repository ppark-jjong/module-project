package com.example.erp.dto;

import com.example.erp.entity.NewStock;
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
}
