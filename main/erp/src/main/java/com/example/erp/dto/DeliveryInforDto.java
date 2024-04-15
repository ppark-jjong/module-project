package com.example.erp.dto;

import com.example.erp.entity.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryInforDto {

    private Long deliveryInforId;

    private String clientId;

    private Long productId;

    private Long arrivalCityId;

    private int count;

    private Date eta;

    private String remark;

    @Builder
    public DeliveryInforDto(Long deliveryInforId, String clientId, Long productId, Long arrivalCityId, int count, Date eta, String remark) {
        this.deliveryInforId = deliveryInforId;
        this.clientId = clientId;
        this.productId = productId;
        this.arrivalCityId = arrivalCityId;
        this.count = count;
        this.eta = eta;
        this.remark = remark;
    }


    public static DeliveryInforDto toDto(DeliveryInfor deliveryInfor) {
        return DeliveryInforDto.builder()
                .deliveryInforId(deliveryInfor.getDeliveryInforId())
                .clientId(deliveryInfor.getClient().getClientId())
                .productId(deliveryInfor.getProduct().getProductId())
                .arrivalCityId(deliveryInfor.getArrivalCity().getArrivalCityId())
                .count(deliveryInfor.getCount())
                .eta(deliveryInfor.getEta())
                .remark(deliveryInfor.getRemark())
                .build();
    }

    public static DeliveryInfor toEntity(DeliveryInforDto deliveryInforDto, Client client, Product product,
                                   ArrivalCity arrivalCity) {
        return DeliveryInfor.builder()
                .client(client)
        .build();
    }
}

