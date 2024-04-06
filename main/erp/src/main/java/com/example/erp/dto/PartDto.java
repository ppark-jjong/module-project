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

}
