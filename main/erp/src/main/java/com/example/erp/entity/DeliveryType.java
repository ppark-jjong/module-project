package com.example.erp.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "delivery_type")
@Getter
@NoArgsConstructor
public class DeliveryType {

    @Builder
    public DeliveryType(Long deliveryTypeId, DeliveryUser deliveryUser, Long deliveryType, ArrivalCity arrivalCity) {
        this.deliveryTypeId = deliveryTypeId;
        this.deliveryUser = deliveryUser;
        this.deliveryType = deliveryType;
        this.arrivalCity = arrivalCity;
    }

    @Id
    @Column(name = "delivery_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_user_id")
    private DeliveryUser deliveryUser;

    @Column(name = "delivery_type")
    private Long deliveryType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_city_id")
    private ArrivalCity arrivalCity;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deliveryType")
    private List<Shipment> shipmentList;

    @Override
    public boolean equals(Object o) {
        if (o instanceof DeliveryType) {
            DeliveryType d = (DeliveryType)o;
            return this.hashCode()== d.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.deliveryTypeId).hashCode();
    }
}
