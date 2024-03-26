package org.example.module.dto;

import lombok.Data;
import org.example.module.entity.Part;

import java.util.List;
@Data
public class ProductDto {
    private int id;

    private int weight;

    private int price;

    private String name;

}