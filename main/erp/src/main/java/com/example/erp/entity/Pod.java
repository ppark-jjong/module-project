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
    private long podId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @Column(name = "time")
    private Date time;

}
