package org.example.module.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Storage {

    @Id
    private int storageId;

    @Column
    private String storageName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storageIdToPart")
    private List<Part> partListInStorage = new ArrayList<>();
}