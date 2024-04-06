package org.example.module.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.module.entity.Location;
import org.example.module.entity.Part;

import java.util.List;

@Data
public class LocationDto {

    private int id;

    private String name;

    private int capacity;

    public Location toEntity() {
        Location entity = new Location();
        entity.setId(id);
        entity.setName(name);
        entity.setCapacity(capacity);

        return entity;
    }

    public void insertEntity(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.capacity = location.getCapacity();
    }
}