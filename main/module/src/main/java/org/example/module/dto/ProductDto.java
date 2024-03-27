package org.example.module.dto;

import lombok.Data;
import org.example.module.entity.Part;
import org.example.module.entity.Product;
import org.example.module.entity.Storage;

import java.util.List;
@Data
public class ProductDto {
    private int id;

    private int weight;

    private int price;

    private String name;

    public void insertEntity(Product product) {
        this.id = product.getId();
        this.weight = product.getWeight();
        this.price = product.getPrice();
        this.name = product.getName();
    }

    public Product toEntity() {
        Product product = new Product();
        product.setId(id);
        product.setWeight(weight);
        product.setPrice(price);
        product.setName(name);
        return product;
    }
}