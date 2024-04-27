package com.example.erp.dto;

import com.example.erp.entity.ArrivalCity;
import com.example.erp.entity.DeliveryType;
import lombok.*;

@Getter
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArrivalCityDto {

    @Builder
    public ArrivalCityDto(Long arrivalCityId, String city, String longtitue, String lattitue) {
        this.arrivalCityId = arrivalCityId;
        this.city = city;
        this.longtitue = longtitue;
        this.lattitue = lattitue;
    }

    private Long arrivalCityId;
    private String city;
    private String longtitue;
    private String lattitue;

    public static ArrivalCityDto toDto(ArrivalCity arrivalCity) {
        return ArrivalCityDto.builder()
                .arrivalCityId(arrivalCity.getArrivalCityId())
                .city(arrivalCity.getCity())
                .longtitue(arrivalCity.getLongtitue())
                .lattitue(arrivalCity.getLattitue())
                .build();
    }

    public ArrivalCity toEntity() {
        return ArrivalCity.builder()
                .arrivalCityId(arrivalCityId)
                .city(city)
                .longtitue(longtitue)
                .lattitue(lattitue)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrivalCityDto) {
            ArrivalCityDto a = (ArrivalCityDto)o;
            return this.hashCode()== a.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.arrivalCityId).hashCode();
    }
}