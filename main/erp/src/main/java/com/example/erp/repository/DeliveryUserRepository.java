package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.DeliveryUser;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "delivery_user")
public interface DeliveryUserRepository extends JpaRepository<DeliveryUser, Long> {
}
