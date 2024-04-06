package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.Shipment;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "shipment")
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
