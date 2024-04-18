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
    public ArrivalCityDto(Long arrivalCityId, String city) {
        this.arrivalCityId = arrivalCityId;
        this.city = city;
    }

    private Long arrivalCityId;
    private String city;

    public static ArrivalCityDto toDto(ArrivalCity arrivalCity) {
        return ArrivalCityDto.builder()
                .arrivalCityId(arrivalCity.getArrivalCityId())
                .city(arrivalCity.getCity())
                .build();
    }

    public ArrivalCity toEntity() {
        return ArrivalCity.builder()
                .id(arrivalCityId)
                .city(city).build();
    }
}