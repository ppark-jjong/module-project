package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "shipment")
@Getter
@NoArgsConstructor
public class Shipment {

    @Id
    @Column(name = "shipment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shipmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "part_id")
    private Part part;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_type_id")
    private DeliveryType deliveryType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_infor_id")
    private DeliveryInfor deliveryInfor;

    @Column(name = "departures")
    private String departures;

    @Column(name = "state")
    private int state;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment")
    private List<Pod> podList;
}
