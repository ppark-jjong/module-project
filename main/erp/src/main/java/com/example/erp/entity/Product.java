package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Builder
    public Product(long productId, float size, float price, String name) {
        this.productId = productId;
        this.size = size;
        this.price = price;
        this.name = name;
    }

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "size")
    private float size;

    @Column(name = "price")
    private float price;

    @Column(name = "name")
    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Part> productInpartList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<DeliveryInfor> productInDeliveryInforList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<NewStock> productInnewStockList;
}
