package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "pod")
@Getter
@NoArgsConstructor
public class Pod {

    @Id
    @Column(name = "pod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shipmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id")
    private Section shipment;

    @Column(name = "time")
    private Date time;

}
