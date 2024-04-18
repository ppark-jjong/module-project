package com.example.erp.dto;

import com.example.erp.entity.DeliveryType;
import com.example.erp.entity.DeliveryUser;
import lombok.*;

import java.util.Date;

@Getter
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class DeliveryTypeDto {

    private Long deliveryTypeId;

    private Long deliveryUserId;

    private String deliveryType;


    @Builder
    public DeliveryTypeDto(Long deliveryTypeId, Long deliveryUserId, String deliveryType) {
        this.deliveryTypeId = deliveryTypeId;
        this.deliveryUserId = deliveryUserId;
        this.deliveryType = deliveryType;
    }

    public static DeliveryTypeDto toDto(DeliveryType deliveryType) {
        return DeliveryTypeDto.builder()
                .deliveryTypeId(deliveryType.getDeliveryTypeId())
                .deliveryUserId(deliveryType.getDeliveryUser().getDeliveryUserId())
                .deliveryType(deliveryType.getDeliveryType())
                .build();
    }

    public DeliveryType toEntity(DeliveryUser deliveryUser) {
        return DeliveryType.builder()
                .deliveryTypeId(deliveryTypeId)
                .deliveryUser(deliveryUser)
                .deliveryType(deliveryType)
                .build();
    }
}