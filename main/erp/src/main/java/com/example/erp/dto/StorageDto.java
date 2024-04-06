package com.example.erp.dto;

import com.example.erp.entity.ArrivalCity;
import com.example.erp.entity.Product;
import com.example.erp.entity.Storage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StorageDto {
    @Builder
    public StorageDto(long storageId, int capacity, double currentCapacity, ArrivalCity arrivalCity) {
        this.storageId = storageId;
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
        this.arrivalCity = arrivalCity;
    }

    private long storageId;
    private int capacity;
    private double currentCapacity;
    private ArrivalCity arrivalCity;

    public void toDto(Storage storage) {
        this.storageId = storage.getStorageId();
        this.capacity = storage.getCapacity();
        this.currentCapacity = storage.getCurrentCapacity();
        this.arrivalCity = storage.getArrivalCity();
    }

    public Storage toEntity() {
        return Storage.builder()
                .capacity(capacity)
                .currentCapacity(currentCapacity)
                .arrivalCity(arrivalCity)
                .build();
    }

}