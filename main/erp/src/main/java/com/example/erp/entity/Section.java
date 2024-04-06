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
    public Section(int capacity, double currentCapacity) {
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
    }

    @Id
    @Column(name = "section_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectionId;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "current_capacity")
    private double currentCapacity;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
    private List<Part> partList = new ArrayList<Part>();
}
