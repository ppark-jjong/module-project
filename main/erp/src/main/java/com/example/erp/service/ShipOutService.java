package com.example.erp.service;

import com.example.erp.dto.PartDto;
import com.example.erp.dto.StorageDto;
import com.example.erp.entity.DeliveryInfor;
import com.example.erp.entity.Storage;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
//출고에 관한 서비스
public class ShipOutService {

    private final StorageRepository storageRepository;
    private final SectionRepository sectionRepository;
    private final ProductRepository productRepository;
    private final PartRepository partRepository;
    private final NewStockRepository newStockRepository;
    private final ArrivalCityRepository arrivalCityRepository;

    @Autowired
    public ShipOutService(StorageRepository storageRepository,
                          SectionRepository sectionRepository, ProductRepository productRepository,
                          PartRepository partRepository, NewStockRepository newStockRepository,
                          ArrivalCityRepository arrivalCityRepository) {
        this.storageRepository = storageRepository;
        this.sectionRepository = sectionRepository;
        this.productRepository = productRepository;
        this.partRepository = partRepository;
        this.newStockRepository = newStockRepository;
        this.arrivalCityRepository = arrivalCityRepository;
    }

    //주문 생성
//    public DeliveryInfor createOrder() {
//
//    }

    //현재날짜 기준 생성된 주문 리스트 출력

    //재고 찾기

//    public PartDto check


    //
//    public StorageDto findNearStorage() {
//
//    }

//}
}