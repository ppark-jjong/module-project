package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private List<Part> productInpartList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<DeliveryInfor> productInDeliveryInforList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<NewStock> productInnewStockList;
}
