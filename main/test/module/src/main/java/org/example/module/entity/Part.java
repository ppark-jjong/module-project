package org.example.module.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Part {

    @Id
    private int id;

    @Column
    private Date stockStartDate;




    @JoinColumn(name = "location_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Location locationIdToPart;

    @JoinColumn(name = "storage_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Storage storageIdToPart;

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product productIdToPart;



    public Part(Location locationIdToPart, Storage storageIdToPart, Product productIdToPart) {
        this.locationIdToPart = locationIdToPart;
        this.storageIdToPart = storageIdToPart;
        this.productIdToPart = productIdToPart;
    }
}
