package com.example.erp.repository;

import com.example.erp.entity.ArrivalCity;
import com.example.erp.entity.Client;
import com.example.erp.entity.Storage;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Table(name = "storage")
public interface StorageRepository extends JpaRepository<Storage, Long> {
    Optional<Storage> findById(Long id);

    Optional<Storage> findByArrivalCity(ArrivalCity arrivalCity);
}
