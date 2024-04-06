package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.NewStock;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "new_stock")
public interface NewStockRepository extends JpaRepository<NewStock, Long> {
}
