package com.example.erp.dto;

import com.example.erp.entity.Product;
import com.example.erp.entity.Section;
import com.example.erp.entity.Storage;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SectionDto {

    @Builder
    public SectionDto(Long sectionId, long storageId, int sectionNumber, int capacity, int currentCapacity) {
        this.sectionId = sectionId;
        this.storageId = storageId;
        this.sectionNumber = sectionNumber;
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
    }

    private Long sectionId;
    private Long storageId;
    private int sectionNumber;
    private int capacity;
    @Setter
    private int currentCapacity;

    public static SectionDto toDto(Section section) {
        return SectionDto.builder()
                .sectionId(section.getSectionId())
                .storageId(section.getStorage().getStorageId())
                .sectionNumber(section.getSectionNumber())
                .capacity(section.getCapacity())
                .currentCapacity(section.getCurrentCapacity())
                .build();
    }

    public Section toEntity(Storage storage) {
        return Section.builder()
                .sectionId(sectionId)
                .storage(storage)
                .sectionNumber(sectionNumber)
                .capacity(capacity)
                .currentCapacity(currentCapacity)
                .build();
    }


}