package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "arrival_city")
@Getter
@NoArgsConstructor
public class ArrivalCity {

    @Id
    @Column(name = "arrival_city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "city")
    private String city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalCity")
    private List<Storage> storageList = new ArrayList<Storage>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalCity")
    private List<Order> orderList = new ArrayList<Order>();
}
