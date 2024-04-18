package com.example.erp.dto;

import com.example.erp.entity.ArrivalCity;
import lombok.*;

@Getter
@Setter(AccessLevel.PUBLIC)
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
                .arrivalCityId(arrivalCityId)
                .city(city).build();
    }
}