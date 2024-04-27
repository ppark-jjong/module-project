package com.example.erp.dto;
import com.example.erp.entity.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryTypeDto {

    private Long deliveryTypeId;

    private Long deliveryUserId;

    private Long deliveryType;

    private Long arrivalCityId;


    @Builder
    public DeliveryTypeDto(Long deliveryTypeId, Long deliveryUserId, Long deliveryType, Long arrivalCityId) {
        this.deliveryTypeId = deliveryTypeId;
        this.deliveryUserId = deliveryUserId;
        this.deliveryType = deliveryType;
        this.arrivalCityId = arrivalCityId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DeliveryTypeDto) {
            DeliveryTypeDto d = (DeliveryTypeDto) o;
            return this.hashCode() == d.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.deliveryTypeId).hashCode();
    }

    public static DeliveryTypeDto toDto(DeliveryType deliveryType) {
        return DeliveryTypeDto.builder()
                .deliveryTypeId(deliveryType.getDeliveryTypeId())
                .deliveryUserId(deliveryType.getDeliveryUser().getDeliveryUserId())
                .deliveryType(deliveryType.getDeliveryType())
                .arrivalCityId(deliveryType.getArrivalCity().getArrivalCityId())
                .build();
    }

    public DeliveryType toEntity(DeliveryUser deliveryUser, ArrivalCity arrivalCity) {
        return DeliveryType.builder()
                .deliveryTypeId(deliveryTypeId)
                .deliveryUser(deliveryUser)
                .deliveryType(deliveryType)
                .arrivalCity(arrivalCity)
                .build();
    }
}