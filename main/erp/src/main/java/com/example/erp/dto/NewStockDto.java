package com.example.erp.dto;

import com.example.erp.entity.NewStock;
import com.example.erp.entity.Product;
import com.example.erp.entity.Storage;
import lombok.*;

import java.util.Date;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
                .stockid()
                .storage(storage)
                .product(product)
                .count(count)
                .stockDate(stockDate)
                .build();
    }
}