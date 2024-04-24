package com.example.erp.repository;

import com.example.erp.entity.Client;
import com.example.erp.entity.DeliveryType;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table(name = "delivery_type")
public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, Long> {
    DeliveryType findByArrivalCity_ArrivalCityId(Long arrivalCityId);
    List<DeliveryType> findAllByArrivalCity_ArrivalCityIdAndDeliveryType(Long arrivalCityId, Long deliveryType);
    List<DeliveryType> findAllByDeliveryType(Long deliveryType);
}
