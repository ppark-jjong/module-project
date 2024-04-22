package com.example.erp.dto;

import com.example.erp.entity.DeliveryInfor;
import com.example.erp.entity.DeliveryType;
import com.example.erp.entity.Part;
import com.example.erp.entity.Shipment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ShipmentDto {
    @Builder
    public ShipmentDto(Long shipmentId, Long part, Long deliveryType, Long deliveryInFor, String departures, int state) {
        this.shipmentId = shipmentId;
        this.part = part;
        this.deliveryType = deliveryType;
        this.deliveryInFor = deliveryInFor;
        this.departures = departures;
        this.state = state;
    }

    private Long shipmentId;

    private Long part;

    private Long deliveryType;

    private Long deliveryInFor;

    private String departures;

    private int state;

    public ShipmentDto toDto(Shipment shipment) {
        return ShipmentDto.builder()
                .shipmentId(shipment.getShipmentId())
                .part(shipment.getPart().getPartId())
                .deliveryType(shipment.getDeliveryType().getDeliveryTypeId())
                .deliveryInFor(shipment.getShipmentId())
                .departures(shipment.getDepartures())
                .state(shipment.getState())
                .build();
    }

    public Shipment toEntity(Part part, DeliveryType deliveryType, DeliveryInfor deliveryInFor){
        return Shipment
                .builder()
                .shipmentId(shipmentId)
                .part(part)
                .deliveryType(deliveryType)
                .deliveryInFor(deliveryInFor)
                .departures(departures)
                .state(state)
                .build();
    }
}