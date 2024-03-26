package org.example.module.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Location {

    @Id
    private String locationId;

    @Column
    private String locationName;

    @Column
    private int capacity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "")
    private List<Part> partListInLocation;
}