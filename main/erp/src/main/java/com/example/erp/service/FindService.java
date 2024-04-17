package com.example.erp.service;

import com.example.erp.dto.ArrivalCityDto;
import com.example.erp.dto.PartDto;
import com.example.erp.dto.SectionDto;
import com.example.erp.dto.StorageDto;
import com.example.erp.entity.ArrivalCity;
import com.example.erp.entity.Part;
import com.example.erp.entity.Section;
import com.example.erp.entity.Storage;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

        ArrivalCityDto arrivalCityDto = ArrivalCityDto.toDto(arrivalCity);
        return arrivalCityDto;
    }

    // 저장소 찾기
    public StorageDto findStorageById(long storageId) {
        Storage storage = storageRepository.findById(storageId)
                .orElseThrow(() -> new IllegalArgumentException("no storage exist"));

        StorageDto storageDto = StorageDto.toDto(storage);
        return storageDto;
    }

    // 섹션 찾기
    public SectionDto findSectionById(long sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new IllegalArgumentException("no section exist"));


        SectionDto sectionDto = SectionDto.toDto(section);
        return sectionDto;
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