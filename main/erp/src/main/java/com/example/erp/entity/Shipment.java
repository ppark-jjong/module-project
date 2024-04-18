package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "shipment")
@Getter
@NoArgsConstructor
public class Shipment {

    @Builder
    public Shipment(Long shipmentId, Part part, DeliveryType deliveryType,
                    DeliveryInfor deliveryInFor, String departures, int state) {
        this.shipmentId = shipmentId;
        this.part = part;
        this.deliveryType = deliveryType;
        this.deliveryInFor = deliveryInFor;
        this.departures = departures;
        this.state = state;
    }


    @Id
    @Column(name = "shipment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_id")
    private Part part;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_type_id")
    private DeliveryType deliveryType;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_infor_id")
    private DeliveryInfor deliveryInFor;

    @Column(name = "departures")
    private String departures;

    @Column(name = "state")
    private int state;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment")
    private List<Pod> podList;
}
