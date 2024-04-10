package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
@Getter
@NoArgsConstructor
public class Section {

    @Builder
    public Section(long sectionId, Storage storage, int sectionNumber, int capacity, int currentCapacity) {
        this.sectionId = sectionId;
        this.storage = storage;
        this.sectionNumber = sectionNumber;
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
    }

    @Id
    @Column(name = "section_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @Column(name = "section_number")
    private int sectionNumber;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "current_capacity")
    private int currentCapacity;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
    private List<Part> partList;
}
