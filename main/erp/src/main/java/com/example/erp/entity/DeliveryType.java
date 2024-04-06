package com.example.erp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delivery_type")
@Getter
@NoArgsConstructor
public class DeliveryType {

    public DeliveryType(DeliveryUser deliveryUser, String deliveryType) {
        this.deliveryUser = deliveryUser;
        this.deliveryType = deliveryType;
    }

    @Id
    @Column(name = "delivery_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deliveryTypeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_user_id")
    private DeliveryUser deliveryUser;

    @Column(name = "delivery_type")
    private String deliveryType;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deliveryType")
    private List<Shipment> shipmentList;
}
