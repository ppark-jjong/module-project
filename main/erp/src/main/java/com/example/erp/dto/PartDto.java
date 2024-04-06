package com.example.erp.dto;

import com.example.erp.entity.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.cert.PKIXParameters;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PartDto {
    @Builder
    public PartDto(long id, long storageId, long sectionId, long productId, Date startStock) {
        this.id = id;
        this.storageId = storageId;
        this.sectionId = sectionId;
        this.productId = productId;
        this.startStock = startStock;
    }

    private long id;
    private long storageId;
    private long sectionId;
    private long productId;
    private Date startStock;

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