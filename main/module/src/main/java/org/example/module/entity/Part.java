package org.example.module.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Part {

    @Id
    private int id;

    @JoinColumn(name = "location_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Location locationIdToPart;

    @JoinColumn(name = "storage_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Storage storageIdToPart;

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product productIdToPart;
}
