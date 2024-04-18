package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "pod")
@Getter
@NoArgsConstructor
public class Pod {

    @Builder
    public Pod(Long podId, Shipment shipment, Date time) {
        this.podId = podId;
        this.shipment = shipment;
        this.time = time;
    }

    @Id
    @Column(name = "pod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long podId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @Column(name = "time")
    private Date time;

}
