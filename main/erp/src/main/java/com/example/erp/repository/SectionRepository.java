package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.Section;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "section")
public interface SectionRepository extends JpaRepository<Section, Long> {
}
