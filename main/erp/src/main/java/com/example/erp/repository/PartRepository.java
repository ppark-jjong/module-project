package com.example.erp.repository;

import com.example.erp.entity.*;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Table(name = "part")
public interface PartRepository extends JpaRepository<Part, Long> {

    List<Part> findBySectionAndEndStock(Section section, Date nowdate);

    List<Part> findBySection(Section section);

    Optional<Part> findByProduct_ProductId(Long productId);
    Optional<Part> findByProduct_ProductIdAndStorage_StorageId(Long partId, Long storageId);
    Optional<Part> findByProductAndStorage(Product product, Storage storage);

    @Query(
            value = "select * from part where storage_id != :storageId order by stroage_id",
            nativeQuery = true)
    List<Part> findByPartExceptionStorage(@Param(value = "storageId") Long storageId);

}
