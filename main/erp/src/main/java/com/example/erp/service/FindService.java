package com.example.erp.service;

import com.example.erp.dto.*;
import com.example.erp.entity.*;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class FindService {
    private final StorageRepository storageRepository;
    private final SectionRepository sectionRepository;
    private final ProductRepository productRepository;
    private final PartRepository partRepository;
    private final NewStockRepository newStockRepository;
    private final ArrivalCityRepository arrivalCityRepository;
    private final DeliveryTypeRepository deliveryTypeRepository;
    private final DeliveryUserRepository deliveryUserRepository;

    @Autowired
    public FindService(StorageRepository storageRepository, SectionRepository sectionRepository,
                       ProductRepository productRepository, PartRepository partRepository,
                       NewStockRepository newStockRepository, ArrivalCityRepository arrivalCityRepository,
                       DeliveryTypeRepository deliveryTypeRepository, DeliveryUserRepository deliveryUserRepository) {
        this.storageRepository = storageRepository;
        this.sectionRepository = sectionRepository;
        this.productRepository = productRepository;
        this.partRepository = partRepository;
        this.newStockRepository = newStockRepository;
        this.arrivalCityRepository = arrivalCityRepository;
        this.deliveryTypeRepository = deliveryTypeRepository;
        this.deliveryUserRepository = deliveryUserRepository;
    }


    // 도시 찾기
    public ArrivalCityDto findArrivalCityById(Long arrivalCityId) {
        ArrivalCity arrivalCity = arrivalCityRepository.findById(arrivalCityId)
                .orElseThrow(() -> new IllegalArgumentException("no arrivalCity exist"));

        return ArrivalCityDto.toDto(arrivalCity);
    }

    // 스토리지 찾기
    public StorageDto findStorageById(Long storageId) {
        Storage storage = storageRepository.findById(storageId)
                .orElseThrow(() -> new IllegalArgumentException("no storage exist"));

        return StorageDto.toDto(storage);
    }

    // 섹션 찾기
    public SectionDto findSectionById(Long sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new IllegalArgumentException("no section exist"));

        return SectionDto.toDto(section);
    }

    // 상품 찾기
    public ProductDto findProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("no product exist"));

        return ProductDto.toDto(product);
    }

    // 배송 기사 찾기
    public DeliveryUserDto findDeliveryUserById(Long deliveryUserId) {
        DeliveryUser deliveryUser = deliveryUserRepository.findById(deliveryUserId)
                .orElseThrow(() -> new IllegalArgumentException("no delivery user exist"));

        return DeliveryUserDto.toDto(deliveryUser);
    }

    // 상품 ID로 파트 찾기
    public PartDto findPartByProductId(Long productId) {
        Part part = partRepository.findByProduct_ProductId(productId)
                .orElseThrow(() -> new IllegalArgumentException("no part exist"));

        return PartDto.toDto(part);
    }

    // 배송 타입으로 DeliveryType 리스트 찾기
    public List<DeliveryTypeDto> findDeliveryTypeByDeliveryType(Long deliveryTypeId) {
        List<DeliveryType> deliveryTypeList = deliveryTypeRepository.findAllByDeliveryType(deliveryTypeId);

        List<DeliveryTypeDto> deliveryTypeDtoList = new ArrayList<>();
        for (DeliveryType deliveryType : deliveryTypeList) {
            deliveryTypeDtoList.add(DeliveryTypeDto.toDto(deliveryType));
        }

        return deliveryTypeDtoList;
    }

    // 도시, 배송 타입으로 DeliveryType 리스트 찾기
    // 함수명 뭔
    public List<DeliveryTypeDto> findDeliveryTypeListByArrivalCityAndDeliveryType(Long arrivalCityId, Long deliveryTypeId) {
        List<DeliveryType> deliveryTypeList = deliveryTypeRepository
                .findAllByArrivalCity_ArrivalCityIdAndDeliveryType(arrivalCityId, deliveryTypeId);

        List<DeliveryTypeDto> deliveryTypeDtoList = new ArrayList<>();
        for (DeliveryType deliveryType : deliveryTypeList) {
            deliveryTypeDtoList.add(DeliveryTypeDto.toDto(deliveryType));
        }

        return deliveryTypeDtoList;
    }

    // 모든 DeliveryType에서 중복 없이 ArrivalCity 탐색
    public List<ArrivalCityDto> findAllArrivalCityInDeliveryType() {
        Set<ArrivalCityDto> arrivalCityDtoSet = new HashSet<>();
        List<DeliveryType> deliveryTypeList = deliveryTypeRepository.findAll();
        for (DeliveryType deliveryType : deliveryTypeList) {
            arrivalCityDtoSet.add(ArrivalCityDto.toDto(deliveryType.getArrivalCity()));
        }

        List<ArrivalCityDto> arrivalCityDtoList = new ArrayList<>(arrivalCityDtoSet);
        return arrivalCityDtoList;
    }

    // 특정 스토리지에 보관되어있는 물품 리스트 찾기
    public List<PartDto> stockPartList(Long storageId) {
        List<Part> entitylist = partRepository.findBySection(
                sectionRepository.findByStorage(
                        storageRepository.findById(storageId).get()).get());

        // return Dto type data
        return entitylist.stream()
                .map(PartDto::toDto)
                .toList();
    }

    // 특정 스토리지에 보관되어있는 특정 물품 리스트 찾기

    // 특정 물품을 가지고 있는 스토리지 리스트 찾기

}