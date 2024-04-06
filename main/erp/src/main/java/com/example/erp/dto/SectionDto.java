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
    public SectionDto(long sectionId, int capacity, double currentCapacity) {
        this.sectionId = sectionId;
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
    }

    private long sectionId;
    private int capacity;
    private double currentCapacity;

    public void toDto(Section section) {
        this.sectionId = section.getSectionId();
        this.capacity = section.getCapacity();
        this.currentCapacity = section.getCurrentCapacity();
    }

    public Section toEntity() {
        return Section.builder()
                .capacity(capacity)
                .currentCapacity(currentCapacity).build();
    }


}