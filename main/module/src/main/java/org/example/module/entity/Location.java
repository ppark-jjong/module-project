package org.example.module.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Location {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    //수용량
    private int capacity;
}