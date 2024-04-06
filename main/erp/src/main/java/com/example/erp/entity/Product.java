package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor
public class Product {

    public Product(float size, float price) {
        this.size = size;
        this.price = price;
    }

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "size")
    private float size;

    @Column(name = "price")
    private float price;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Part> partList = new ArrayList<Part>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Order> orderList = new ArrayList<Order>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<NewStock> newStockList = new ArrayList<NewStock>();
}
