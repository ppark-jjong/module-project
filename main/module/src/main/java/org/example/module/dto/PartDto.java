package org.example.module.dto;

import lombok.Data;
import org.example.module.entity.Location;
import org.example.module.entity.Part;
import org.example.module.entity.Product;
import org.example.module.entity.Storage;

@Data
public class PartDto {
    private int id;

    private Location locationIdToPart;

    private Storage storageIdToPart;

    private Product productIdToPart;

    public PartDto(Location locationIdToPart, Storage storageIdToPart, Product productIdToPart) {
        this.locationIdToPart = locationIdToPart;
        this.storageIdToPart = storageIdToPart;
        this.productIdToPart = productIdToPart;
    }

    public Part toEntity() {
        Part part = new Part();
        part.setId(id);
        part.setLocationIdToPart(locationIdToPart);
        part.setStorageIdToPart(storageIdToPart);
        part.setProductIdToPart(productIdToPart);
        return part;
    }

    public void insertEntity(Part part) {
        this.id = part.getId();
        this.locationIdToPart = part.getLocationIdToPart();
        this.storageIdToPart = part.getStorageIdToPart();
        this.productIdToPart = part.getProductIdToPart();
    }
}