package com.example.erp.dto;

import com.example.erp.entity.DeliveryUser;
import com.example.erp.entity.Part;
import com.example.erp.entity.Product;
import com.example.erp.entity.Section;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryTypeDto {

    private Long deliveryTypeId;

    private Long deliveryUser;

    private String deliveryType;


    @Builder
    public DeliveryTypeDto(Long deliveryTypeId, Long deliveryUser, String deliveryType) {
        this.deliveryTypeId = deliveryTypeId;
        this.deliveryUser = deliveryUser;
        this.deliveryType = deliveryType;
    }


    public static DeliveryTypeDto toDto(Part part) {

    }

    public DeliveryType(Section section, Product product) {
        return Part.builder()
                .section(section)
                .product(product)
                .startStock(startStock)
                .endStock(endStock)
                .build();
    }
}