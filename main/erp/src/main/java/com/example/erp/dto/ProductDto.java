package com.example.erp.dto;


import com.example.erp.entity.Product;
import com.example.erp.service.WarehousingService;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDto {
    private long productId;
    private float size;
    private float price;

    @Builder
    public ProductDto(long productId, float size, float price) {
        this.productId = productId;
        this.size = size;
        this.price = price;
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .size(product.getSize())
                .price(product.getPrice())
                .build();
    }

    public static Product toEntity(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.productId)
                .size(productDto.getSize())
                .price(productDto.getPrice())
                .build();
    }
}

