package org.example.module.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    private int id;

    @Column
    private int weight;

    @Column
    private int price;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productIdToPart")
    private List<Part> partListIdToProduct;

}