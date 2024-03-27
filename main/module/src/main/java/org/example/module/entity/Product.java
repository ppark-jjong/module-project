package org.example.module.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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