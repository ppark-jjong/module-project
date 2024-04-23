package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "storage")
@Getter
@NoArgsConstructor
public class Storage {

    @Builder
    public Storage(Long storageId, int state, int capacity, String address, ArrivalCity arrivalCity) {
        this.storageId = storageId;
        this.state = state;
        this.capacity = capacity;
        this.address = address;
        this.arrivalCity = arrivalCity;
    }

    @Id
    @Column(name = "storage_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageId;

    @Column(name = "state")
    private int state;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_city_id")
    private ArrivalCity arrivalCity;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storage")
    private List<Section> sectionList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storage")
    private List<NewStock> newStockList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storage")
    private List<Part> partList;
}
