package org.example.module.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    private int productId;

    @Column
    private int productType;

    @Column
    private int productWeight;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productIdToPart")
    private List<Part> partListIdToProduct;
}