package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.Product;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "product")
public interface ProductRepository extends JpaRepository<Product, Long> {
}
