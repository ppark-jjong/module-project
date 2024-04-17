package com.example.erp.dto;

import com.example.erp.entity.ArrivalCity;
import com.example.erp.entity.Product;
import com.example.erp.entity.Storage;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StorageDto {

    @Builder
    public StorageDto(long storageId, int state, int capacity, Long arrivalCity) {
        this.storageId = storageId;
        this.state = state;
        this.capacity = capacity;
        this.arrivalCity = arrivalCity;
    }

    private long storageId;
    @Setter
    private int state;
    private int capacity;
    private Long arrivalCity;

    public static StorageDto toDto(Storage storage) {
        return StorageDto.builder()
                .storageId(storage.getStorageId())
                .state(storage.getState())
                .capacity(storage.getCapacity())
                .arrivalCity(storage.getArrivalCity().getArrivalCityId())
                .build();
    }

    public Storage toEntity( ArrivalCity arrivalCity) {
        return Storage.builder()
                .storageId(storageId)
                .state(state)
                .capacity(capacity)
                .arrivalCity(arrivalCity)
                .build();
    }

}