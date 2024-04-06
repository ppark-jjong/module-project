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
    public Order(Date eta, int count, ArrivalCity arrivalCity, Order order, Product clientId, @Nullable String remark) {
        this.remark = remark;
        this.eta = eta;
        this.count = count;
        this.arrivalCity = arrivalCity;
        this.order = order;
        this.clientId = clientId;
    }

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Product clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

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
