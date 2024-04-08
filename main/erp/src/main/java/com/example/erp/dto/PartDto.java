package com.example.erp.dto;


import com.example.erp.entity.Part;
import com.example.erp.entity.Product;
import com.example.erp.entity.Section;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PartDto {
    @Builder
    public PartDto(long partId, long sectionId, long productId, Date startStock, Date endStock) {
        this.partId = partId;
        this.sectionId = sectionId;
        this.productId = productId;
        this.startStock = startStock;
        this.endStock = endStock;
    }

    private long partId;
    private long sectionId;
    private long productId;
    private Date startStock;
    private Date endStock;


    public void toDto(Part part) {
        this.sectionId = part.getSection().getSectionId();
        this.productId = part.getProduct().getProductId();
        this.startStock = part.getStartStock();
        this.endStock = part.getEndStock();
    }

    public Part toEntity(Section section, Product product) {
        return Part.builder()
                .section(section)
                .product(product)
                .startStock(startStock)
                .endStock(endStock)
                .build();
    }

}

