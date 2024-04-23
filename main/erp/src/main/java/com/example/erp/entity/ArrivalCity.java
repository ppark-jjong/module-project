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
    public ArrivalCity(Long arrivalCityId, String city, String longtitue, String lattitue) {
        this.arrivalCityId = arrivalCityId;
        this.city = city;
        this.longtitue = longtitue;
        this.lattitue = lattitue;
    }

    @Id
    @Column(name = "arrival_city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arrivalCityId;

    @Column(name = "city")
    private String city;

    @Column(name = "longtitue")
    private String longtitue;

    @Column(name = "lattitue")
    private String lattitue;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalCity")
    private List<Storage> storageList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalCity")
    private List<DeliveryInfor> deliveryInforList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrivalCity")
    private List<DeliveryType> deliveryTypeList;
}
