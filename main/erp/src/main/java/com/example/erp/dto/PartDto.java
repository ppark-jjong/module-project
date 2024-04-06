package com.example.erp.dto;


import com.example.erp.entity.Part;
import com.example.erp.entity.Product;
import com.example.erp.entity.Section;
import com.example.erp.entity.Storage;
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
    private long sectionId;
    private long productId;
    private Date startStock;


    public void toDto(Part part) {
        this.partId = part.getPartId();
        this.sectionId = part.getSection().getSectionId();
        this.productId = part.getProduct().getProductId();
        this.startStock = part.getStartStock();
    }

    public Part toEntity(Section section, Product product) {
        return Part.builder()
                .section(section)
                .product(product)
                .startStock(startStock).build();
    }

}

