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
    public Storage(int capacity, double currentCapacity, ArrivalCity arrivalCity) {
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
        this.arrivalCity = arrivalCity;
    }

    @Id
    @Column(name = "storage_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storageId;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "current_capacity")
    private double currentCapacity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrival_city_id")
    private ArrivalCity arrivalCity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storage")
    private List<Section> sectionList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storage")
    private List<NewStock> newStockList;
}
