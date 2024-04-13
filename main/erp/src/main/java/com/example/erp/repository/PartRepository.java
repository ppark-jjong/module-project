package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.Part;
import com.example.erp.entity.Section;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Table(name = "part")
public interface PartRepository extends JpaRepository<Part, Long> {

    List<Part> findBySectionAndEndStock(Section section, Date nowdate);

    List<Part> findBySection(Section section);

    Optional<Part> findById(Long id);
}
