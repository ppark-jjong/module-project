package com.example.erp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartDto {
    private long partId;
    private long storageId;
    private long sectionId;
    private long productId;
    private Date startStock;

<<<<<<< HEAD
    public void toDto(Part part) {
        this.id = part.getPartId();
        this.storageId = part.getStorage().getStorageId();
        this.sectionId = part.getSection().getSectionId();
        this.productId = part.getProduct().getProductId();
        this.startStock = part.getStartStock();
    }

    public Part toEntity(Storage storage, Section section, Product product) {
        return Part.builder()
                .storage(storage)
                .section(section)
                .product(product)
                .startStock(startStock).build();
    }

}

