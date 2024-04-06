package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.Storage;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "storage")
public interface StorageRepository extends JpaRepository<Storage, Long> {
}
