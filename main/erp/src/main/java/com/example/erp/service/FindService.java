package com.example.erp.service;

import com.example.erp.dto.*;
import com.example.erp.entity.*;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
// JPA Find와 관련된 서비스
public class FindService {
    private final StorageRepository storageRepository;
    private final SectionRepository sectionRepository;
    private final ProductRepository productRepository;
    private final PartRepository partRepository;
    private final NewStockRepository newStockRepository;
    private final ArrivalCityRepository arrivalCityRepository;

    @Autowired
    public FindService(StorageRepository storageRepository, SectionRepository sectionRepository,
                       ProductRepository productRepository, PartRepository partRepository,
                       NewStockRepository newStockRepository, ArrivalCityRepository arrivalCityRepository) {
        this.storageRepository = storageRepository;
        this.sectionRepository = sectionRepository;
        this.productRepository = productRepository;
        this.partRepository = partRepository;
        this.newStockRepository = newStockRepository;
        this.arrivalCityRepository = arrivalCityRepository;
    }


    // 도시 찾기
    public ArrivalCityDto findArrivalCityById(long arrivalCityId) {
        ArrivalCity arrivalCity = arrivalCityRepository.findById(arrivalCityId)
                .orElseThrow(() -> new IllegalArgumentException("no arrivalCity exist"));

        return ArrivalCityDto.toDto(arrivalCity);
    }
    
    public StorageDto findStorageById(Long storageId) {
        Storage storage = storageRepository.findById(storageId)
                .orElseThrow(() -> new IllegalArgumentException("no storage exist"));

        return StorageDto.toDto(storage);
    }

    // 섹션 찾기
    public SectionDto findSectionById(long sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new IllegalArgumentException("no section exist"));

        return SectionDto.toDto(section);
    }

    // 상품 찾기
    public ProductDto findProductById(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("no product exist"));

        return ProductDto.toDto(product);
    }

    // 특정 스토리지에 보관되어있는 물품 리스트 찾기
    public List<PartDto> stockPartList(long storageId) {
        List<Part> entitylist = partRepository.findBySection(
                sectionRepository.findByStorage(
                        storageRepository.findById(storageId).get()).get());
//                return  entitylist.stream()
//                .map((Part part) -> PartDto.toDto(part))
//                .collect(Collectors.toList());

        return entitylist.stream()
                .map(PartDto::toDto)
                .toList();
    }

    // 특정 스토리지에 보관되어있는 특정 물품 리스트 찾기

    // 특정 물품을 가지고 있는 스토리지 리스트 찾기

}