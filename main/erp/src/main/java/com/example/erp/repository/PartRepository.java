package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.Part;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "part")
public interface PartRepository extends JpaRepository<Part, Long> {
}
