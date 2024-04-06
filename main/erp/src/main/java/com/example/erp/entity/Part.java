package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "part")
@Getter
@NoArgsConstructor
public class Part {

    @Builder
    public Part(Storage storage, Section section, Product product, Date startStock) {
        this.storage = storage;
        this.section = section;
        this.product = product;
        this.startStock = startStock;
    }

    @Id
    @Column(name = "part_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long partId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "start_stock")
    private Date startStock;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "part")
    private List<Shipment> ShipmentList;
}
