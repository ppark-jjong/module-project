package com.example.erp.dto;


import com.example.erp.entity.Product;
import com.example.erp.service.WarehousingService;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDto {
    private Long productId;
    private float size;
    private float price;
    private String name;

    @Builder
    public ProductDto(Long productId, float size, float price , String name) {
        this.productId = productId;
        this.size = size;
        this.price = price;
        this.name = name;
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .size(product.getSize())
                .price(product.getPrice())
                .name(product.getName())
                .build();
    }

    public Product toEntity() {
        return Product.builder()
                .productId(productId)
                .size(size)
                .price(price)
                .name(name)
                .build();
    }
}

