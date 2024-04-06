package com.example.erp.dto;

import com.example.erp.entity.ArrivalCity;
import com.example.erp.entity.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArrivalCityDto {
    @Builder
    public ArrivalCityDto(long id, String city) {
        this.id = id;
        this.city = city;
    }

    private long id;
    private String city;

    public void toDto(ArrivalCity arrivalCity) {
        this.id = arrivalCity.getId();
        this.city = arrivalCity.getCity();
    }

    public ArrivalCity toEntity() {
        return ArrivalCity.builder()
                .city(city).build();
    }
}