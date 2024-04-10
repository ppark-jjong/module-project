package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.NewStock;
import com.example.erp.entity.Storage;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "new_stock")
public interface NewStockRepository extends JpaRepository<NewStock, Long> {
    List<NewStock> findAllByStorage(Storage storage);
}
