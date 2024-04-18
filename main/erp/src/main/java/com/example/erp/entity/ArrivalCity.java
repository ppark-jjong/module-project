package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "arrival_city")
@Getter
@NoArgsConstructor
public class ArrivalCity {
    @Builder
    public ArrivalCity(Long id, String city) {
        this.arrivalCityId = id;
        this.city = city;
    }

    @Id
    @Column(name = "arrival_city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arrivalCityId;

    @Column(name = "city")
    private String city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalCity")
    private List<Storage> storageList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalCity")
    private List<DeliveryInfor> deliveryInforList;
}
