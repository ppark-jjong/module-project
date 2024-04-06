package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.Order;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "order")
public interface OrderRepository extends JpaRepository<Order, Long> {
}
