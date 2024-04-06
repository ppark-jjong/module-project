package com.example.erp.dto;


import com.example.erp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private long id;
    private float size;
    private float price;

    public void toProductDto(Product product) {
        this.id = product.getProductId();
        this.size = product.getSize();
        this.price = product.getPrice();

    }
}

