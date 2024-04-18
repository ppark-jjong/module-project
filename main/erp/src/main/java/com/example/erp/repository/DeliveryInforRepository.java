package com.example.erp.repository;

import com.example.erp.entity.DeliveryInfor;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Table(name = "delivery_infor")
public interface DeliveryInforRepository extends JpaRepository<DeliveryInfor, Long> {
    List<DeliveryInfor> findAllByEta(Date date);
}
