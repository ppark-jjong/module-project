package com.example.erp.dto;

import com.example.erp.entity.Pod;
import com.example.erp.entity.Product;
import com.example.erp.entity.Shipment;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PodDto {
    @Builder
    public PodDto(Long podId, Long shipment, Date time) {
        this.podId = podId;
        this.shipment = shipment;
        this.time = time;
    }

    private Long podId;

    private Long shipment;

    private Date time;

    public PodDto toDto(Pod pod) {
        return PodDto.builder()
                .podId(pod.getPodId())
                .shipment(pod.getShipment().getShipmentId())
                .time(pod.getTime())
                .build();
    }

    public Pod toEntity(Shipment shipment) {
        return Pod.builder()
                .podId(podId)
                .shipment(shipment)
                .time(time)
                .build();
    }
}