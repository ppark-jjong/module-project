package com.example.erp.repository;

import com.example.erp.entity.ArrivalCity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Table(name = "arrival_city")
public interface ArrivalCityRepository extends JpaRepository<ArrivalCity, Long> {
    Optional<ArrivalCity> findById(long id);
}
