package org.example.module.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Storage {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    //수용량
    private int capacity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "storageIdToPart")
    private List<Part> partListInStorage = new ArrayList<>();
}