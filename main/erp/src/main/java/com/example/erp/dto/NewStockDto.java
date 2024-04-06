package com.example.erp.dto;

import com.example.erp.entity.NewStock;
import com.example.erp.entity.Product;
import com.example.erp.entity.Storage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NewStockDto {
    @Builder
    public NewStockDto(long newStockId, long storageId, long productId, int count) {
        this.newStockId = newStockId;
        this.storageId = storageId;
        this.productId = productId;
        this.count = count;
    }

    private long newStockId;
    private long storageId;
    private long productId;
    int count;

    public NewStockDto(NewStock o) {
        NewStockDto dto = new NewStockDto();
        dto.toDto(o);
    }

    public void toDto(NewStock newStock) {
        this.newStockId = newStock.getStockId();
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