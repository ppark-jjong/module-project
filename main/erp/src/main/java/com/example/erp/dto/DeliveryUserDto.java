package com.example.erp.dto;


import com.example.erp.entity.DeliveryType;
import com.example.erp.entity.DeliveryUser;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryUserDto {

    @Builder
    public DeliveryUserDto(Long deliveryUserId, String name, String tel, String vehicleNumber, String vehicleType) {
        this.deliveryUserId = deliveryUserId;
        this.name = name;
        this.tel = tel;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    private Long deliveryUserId;

    private String name;

    private String tel;

    private String vehicleNumber;

    private String vehicleType;

    public static DeliveryUserDto toDto(DeliveryUser deliveryUser) {
        return DeliveryUserDto.builder()
                .deliveryUserId(deliveryUser.getDeliveryUserId())
                .name(deliveryUser.getName())
                .tel(deliveryUser.getTel())
                .vehicleNumber(deliveryUser.getVehicleNumber())
                .vehicleType(deliveryUser.getVehicleType())
                .build();
    }

    public DeliveryUser toEntity() {
        return DeliveryUser.builder()
                .deliveryUserId(deliveryUserId)
                .name(name)
                .tel(tel)
                .vehicleNumber(vehicleNumber)
                .vehicleType(vehicleType)
                .build();
    }


}