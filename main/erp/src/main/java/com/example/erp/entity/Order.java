package com.example.erp.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@NoArgsConstructor
public class Order {

    @Builder
    public Order(Date eta, int count, ArrivalCity arrivalCity, Client client, Product product, @Nullable String remark) {
        this.client = client;
        this.product = product;
        this.arrivalCity = arrivalCity;
        this.count = count;
        this.remark = remark;
        this.eta = eta;

    }

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrival_city_id")
    private ArrivalCity arrivalCity;

    @Column(name = "count")
    private int count;

    @Column(name = "eta")
    private Date eta;

    @Column(name = "remark")
    @Nullable
    private String remark;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<Shipment> shipmentList = new ArrayList<Shipment>();
}
