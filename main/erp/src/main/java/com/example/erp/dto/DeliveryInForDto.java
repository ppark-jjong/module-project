package com.example.erp.dto;

import com.example.erp.entity.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryInForDto {

    private Long deliveryInForId;

    private String clientId;

    private Long productId;

    private Long arrivalCityId;

    private int count;

    private Date eta;

    private String remark;

    @Builder
    public DeliveryInForDto(Long deliveryInForId, String clientId, Long productId,
                            Long arrivalCityId, int count, Date eta, String remark) {
        this.deliveryInForId = deliveryInForId;
        this.clientId = clientId;
        this.productId = productId;
        this.arrivalCityId = arrivalCityId;
        this.count = count;
        this.eta = eta;
        this.remark = remark;
    }


    public DeliveryInForDto toDto(DeliveryInfor deliveryInfor) {
        return DeliveryInForDto.builder()
                .deliveryInForId(deliveryInfor.getDeliveryInForId())
                .clientId(deliveryInfor.getClient().getClientId())
                .productId(deliveryInfor.getProduct().getProductId())
                .arrivalCityId(deliveryInfor.getArrivalCity().getArrivalCityId())
                .count(deliveryInfor.getCount())
                .eta(deliveryInfor.getEta())
                .remark(deliveryInfor.getRemark())
                .build();
    }


    public DeliveryInfor toEntity(Client client, Product product,
                                  ArrivalCity arrivalCity) {
        return DeliveryInfor.builder()
                .deliveryInForId(deliveryInForId)
                .client(client)
                .product(product)
                .arrivalCity(arrivalCity)
                .count(count)
                .eta(eta)
                .remark(remark)
                .build();
    }
}

