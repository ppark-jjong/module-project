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
    public Part(long partId, Section section, Product product, Storage storage, Date startStock, Date endStock) {
        this.partId = partId;
        this.section = section;
        this.product = product;
        this.storage = storage;
        this.startStock = startStock;
        this.endStock = endStock;
    }

    @Id
    @Column(name = "part_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @Column(name = "start_stock")
    private Date startStock;

    @Column(name = "end_stock")
    private Date endStock;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "part")
    private List<Shipment> ShipmentList;
}
