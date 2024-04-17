package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delivery_user")
@Getter
@NoArgsConstructor
public class DeliveryUser {

    @Builder
    public DeliveryUser(Long deliveryUserId, String name, String tel, String vehicleNumber, String vehicleType) {
        this.deliveryUserId = deliveryUserId;
        this.name = name;
        this.tel = tel;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    @Id
    @Column(name = "delivery_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryUserId;

    @Column(name = "name")
    private String name;

    @Column(name = "tel")
    private String tel;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "vehicleType")
    private String vehicleType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deliveryUser")
    private List<DeliveryType> deliveryTypeList;
}
