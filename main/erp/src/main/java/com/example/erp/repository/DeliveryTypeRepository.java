package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.DeliveryType;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "delivery_type")
public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Long> {


}
