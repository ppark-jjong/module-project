package com.example.erp.service;

import com.example.erp.dto.NewStockDto;
import com.example.erp.entity.*;
import com.example.erp.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehousingService {

    private final StorageRepository storageRepository;
    private final SectionRepository sectionRepository;
    private final ProductRepository productRepository;
    private final PartRepository partRepository;
    private final NewStockRepository newStockRepository;


    @Autowired
    public WarehousingService(StorageRepository storageRepository,
                              SectionRepository sectionRepository,
                              ProductRepository productRepository,
                              PartRepository partRepository,
                              NewStockRepository newStockRepository) {
        this.storageRepository = storageRepository;
        this.sectionRepository = sectionRepository;
        this.productRepository = productRepository;
        this.partRepository = partRepository;
        this.newStockRepository = newStockRepository;
    }

    //새로운 입고 물품 신청
    @Transactional
    public NewStockDto createNewStock(long storageId, long productId, int count) {

        // 반환 Optional 이딴식으로 하면 메서드 종료 후 어딘가에서 반드시 try catch 예외 처리를 받아야 할텐데
        // 이게 맞나
        Storage storage = storageRepository.findById(storageId)
                .orElseThrow(() -> new IllegalArgumentException("스토리지 없당"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("제품 없당"));

        NewStock newStock = NewStock.builder()
                .storage(storage)
                .product(product)
                .count(count)
                .build();

        NewStockDto newStockDto = new NewStockDto();
        newStockDto.toNewStockDto(newStockRepository.save(newStock));
        return newStockDto;
    }



}
