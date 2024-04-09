package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.Section;
import com.example.erp.entity.Storage;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Table(name = "section")
public interface SectionRepository extends JpaRepository<Section, Long> {

    public Section findByStorageAndSectionNumber (long storageId, int sectionNumber);
    Section findByStorage(Optional<Storage> byId);

}
