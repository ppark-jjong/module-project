package org.example.module.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.example.module.entity.Part;
import org.example.module.entity.Storage;

import java.util.ArrayList;
import java.util.List;

@Data
public class StorageDto {
    private int id;

    private String name;

    private int capacity;

    public void insertEntity(Storage storage) {
        this.id = storage.getId();
        this.name = storage.getName();
        this.capacity = storage.getCapacity();
    }

    public Storage toEntity() {
        Storage storage = new Storage();
        storage.setId(id);
        storage.setName(name);
        storage.setCapacity(capacity);
        return storage;
    }
}