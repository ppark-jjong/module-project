package com.example.erp.dto;

import com.example.erp.entity.DeliveryInfor;
import com.example.erp.entity.NewStock;
import com.example.erp.entity.Part;
import com.example.erp.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDto {
    @Builder
    public ProductDto(long productId, float size, float price, String name) {
        this.productId = productId;
        this.size = size;
        this.price = price;
        this.name = name;
    }

    private long productId;

    private float size;

    private float price;

    private String name;

    public void toDto(Product product) {
        this.productId = product.getProductId();
        this.size = product.getSize();
        this.price = product.getPrice();
        this.name = product.getName();
    }

    public Product toEntity() {
        return Product.builder()
                .size(this.size)
                .price(this.price)
                .name(this.name).build();
    }
}

