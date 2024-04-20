package com.example.erp.repository;

import com.example.erp.entity.*;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Table(name = "part")
public interface PartRepository extends JpaRepository<Part, Long> {

    List<Part> findBySectionAndEndStock(Section section, Date nowdate);

    List<Part> findBySection(Section section);

    Optional<Part> findByProductAndStorage(Long partId, Long storageId);

    @Query(
            value = "select * from part where storage_id != :storageId",
            nativeQuery = true)
    List<Part> findByPartExceptionStorage(@Param(value = "storageId") Long storageId);

}
