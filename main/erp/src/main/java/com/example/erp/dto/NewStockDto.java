package com.example.erp.dto;

import com.example.erp.entity.NewStock;
import com.example.erp.entity.Product;
import com.example.erp.entity.Storage;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class NewStockDto {

    private long stockId;
    private long storageId;
    private long productId;
    private int count;
    private Date stockDate;

    @Builder
    public NewStockDto(long stockId, long storageId, long productId, int count, Date stockDate) {
        this.stockId = stockId;
        this.storageId = storageId;
        this.productId = productId;
        this.count = count;
        this.stockDate = stockDate;
    }

    public NewStockDto(NewStock newStock) {
    }

    @Builder
    public static NewStockDto toDto(NewStock newStock) {
        return NewStockDto.builder()
                .stockId(newStock.getStockId())
                .storageId(newStock.getStorage().getStorageId())
                .productId(newStock.getProduct().getProductId())
                .count(newStock.getCount())
                .stockDate(newStock.getStockDate())
                .build();
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

