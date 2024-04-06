package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.Pod;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "pod")
public interface PodRepository extends JpaRepository<Pod, Long> {
}
