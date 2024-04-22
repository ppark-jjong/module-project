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

    private String address;

    private int count;

    private Date eta;

    private String remark;

    @Builder
    public DeliveryInForDto(Long deliveryInForId, String clientId, Long productId,
                            Long arrivalCityId, String address, int count, Date eta, String remark) {
        this.deliveryInForId = deliveryInForId;
        this.clientId = clientId;
        this.productId = productId;
        this.arrivalCityId = arrivalCityId;
        this.address = address;
        this.count = count;
        this.eta = eta;
        this.remark = remark;
    }


    public static DeliveryInForDto toDto(DeliveryInfor deliveryInfor) {
        return DeliveryInForDto.builder()
                .deliveryInForId(deliveryInfor.getDeliveryInForId())
                .clientId(deliveryInfor.getClient().getClientId())
                .productId(deliveryInfor.getProduct().getProductId())
                .arrivalCityId(deliveryInfor.getArrivalCity().getArrivalCityId())
                .address(deliveryInfor.getAddress())
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
                .address(address)
                .count(count)
                .eta(eta)
                .remark(remark)
                .build();
    }

}

