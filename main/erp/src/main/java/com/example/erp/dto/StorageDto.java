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

    private long storageId;
    private int capacity;
    private double currentCapacity;
    private long arrivalCityId;

    @Builder
    public StorageDto(long storageId, int capacity, double currentCapacity, long arrivalCityId) {
        this.storageId = storageId;
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
        this.arrivalCityId = arrivalCityId;
    }

    public static StorageDto toDto(Storage storage) {
        return StorageDto.builder()
                .storageId(storage.getStorageId())
                .capacity(storage.getCapacity())
                .currentCapacity(storage.getCurrentCapacity())
                .arrivalCityId(storage.getArrivalCity().getId())
                .build();
    }

    public Storage toEntity(ArrivalCity arrivalCity) {
        return Storage.builder()
                .capacity(capacity)
                .currentCapacity(currentCapacity)
                .arrivalCity(arrivalCity)
                .build();
    }

}