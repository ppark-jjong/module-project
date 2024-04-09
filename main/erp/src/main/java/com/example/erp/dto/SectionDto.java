package com.example.erp.dto;

import com.example.erp.entity.Product;
import com.example.erp.entity.Section;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SectionDto {

    @Builder
    public SectionDto(long sectionId, long storageId, int sectionNumber, int capacity, double currentCapacity) {
        this.sectionId = sectionId;
        this.storageId = storageId;
        this.sectionNumber = sectionNumber;
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
    }

    private long sectionId;
    private long storageId;
    private int sectionNumber;
    private int capacity;
    private double currentCapacity;

    public static SectionDto toDto(Section section) {
        return SectionDto.builder()
                .sectionId(section.getSectionId())
                .storageId(section.getStorage().getStorageId())
                .sectionNumber(section.getSectionNumber())
                .capacity(section.getCapacity())
                .currentCapacity(section.getCurrentCapacity())
                .build();
    }

    public Section toEntity() {
        return Section.builder()
                .capacity(capacity)
                .currentCapacity(currentCapacity).build();
    }


}