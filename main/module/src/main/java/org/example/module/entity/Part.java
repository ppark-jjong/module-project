package org.example.module.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Part {

    @Id
    private int partId;

    @JoinColumn(name = "storage_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Storage storageIdToPart;

    @JoinColumn(name = "location_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Location locationIdToPart;

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product productIdToPart;
}
