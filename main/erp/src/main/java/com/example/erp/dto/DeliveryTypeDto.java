package com.example.erp.dto;
import com.example.erp.entity.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class DeliveryTypeDto {

    private Long deliveryTypeId;

    private Long deliveryUserId;

    private String deliveryType;

    private Long arrivalCityId;


    @Builder
    public DeliveryTypeDto(Long deliveryTypeId, Long deliveryUserId, String deliveryType, Long arrivalCityId) {
        this.deliveryTypeId = deliveryTypeId;
        this.deliveryUserId = deliveryUserId;
        this.deliveryType = deliveryType;
        this.arrivalCityId = arrivalCityId;
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