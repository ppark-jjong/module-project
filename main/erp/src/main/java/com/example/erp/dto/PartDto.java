package com.example.erp.dto;


import com.example.erp.entity.Part;
import com.example.erp.entity.Product;
import com.example.erp.entity.Section;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PartDto {
    private Long partId;
    private Long sectionId;
    private Long productId;
    private Date startStock;
    private Date endStock;

    @Builder
    public PartDto(Long partId, Long sectionId, Long productId, Date startStock, Date endStock) {
        this.partId = partId;
        this.sectionId = sectionId;
        this.productId = productId;
        this.startStock = startStock;
        this.endStock = endStock;
    }


    public static PartDto toDto(Part part) {
        return PartDto.builder()
                .partId(part.getPartId())
                .sectionId(part.getSection().getSectionId())
                .productId(part.getProduct().getProductId())
                .startStock(part.getStartStock())
                .endStock(part.getEndStock())
                .build();
    }

    public Part toEntity(Section section, Product product) {
        return Part.builder()
                .partId(partId)
                .section(section)
                .product(product)
                .startStock(startStock)
                .endStock(endStock)
                .build();
    }

}

