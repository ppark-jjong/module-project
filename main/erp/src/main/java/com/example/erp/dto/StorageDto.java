package com.example.erp.dto;

import com.example.erp.entity.ArrivalCity;
import com.example.erp.entity.Product;
import com.example.erp.entity.Storage;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StorageDto {

    @Builder
    public StorageDto(long storageId, int state, int capacity, String address, String x, String y, Long arrivalCity) {
        this.storageId = storageId;
        this.state = state;
        this.capacity = capacity;
        this.address = address;
        this.x = x;
        this.y = y;
        this.arrivalCity = arrivalCity;
    }

    private long storageId;

    @Setter
    private int state;

    private int capacity;

    private String address;

    private String x;

    private String y;

    private Long arrivalCity;

    public static StorageDto toDto(Storage storage) {
        return StorageDto.builder()
                .storageId(storage.getStorageId())
                .state(storage.getState())
                .capacity(storage.getCapacity())
                .address(storage.getAddress())
                .x(storage.getX())
                .y(storage.getY())
                .arrivalCity(storage.getArrivalCity().getArrivalCityId())
                .build();
    }

    public Storage toEntity(ArrivalCity arrivalCity) {
        return Storage.builder()
                .storageId(storageId)
                .state(state)
                .capacity(capacity)
                .address(address)
                .x(x)
                .y(y)
                .arrivalCity(arrivalCity)
                .build();
    }

}