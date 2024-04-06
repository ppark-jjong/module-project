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
    public Order(Product productId, ArrivalCity arrivalCity, int count, Date eta, @Nullable String remark) {
        this.productId = productId;
        this.arrivalCity = arrivalCity;
        this.count = count;
        this.eta = eta;
        this.remark = remark;
    }

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productId;

    @ManyToOne(fetch = FetchType.LAZY)
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
    private List<Shipment> ShipmentList = new ArrayList<Shipment>();
}
