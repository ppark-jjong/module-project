package org.example.module.service;

import org.example.module.dto.PartDto;
import org.example.module.dto.ProductDto;
import org.example.module.dto.StorageDto;
import org.example.module.entity.Storage;
import org.example.module.repository.LocationRepository;
import org.example.module.repository.PartRepository;
import org.example.module.repository.ProductRepository;
import org.example.module.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InStockService {

    private StorageRepository storageRepository;

    private PartRepository partRepository;

    private ProductRepository productRepository;

    private LocationRepository locationRepository;

    /* *************
        DB 정보 조회
     ************* */
    //storage 정보 조회
    public StorageDto selectStorage(String name) {
        Storage storage = storageRepository.findByName(name);
        StorageDto storageDto = new StorageDto();
        storageDto.insertEntity(storage);
        return storageDto;
    }


    /* *************
        DB 정보 조회 끝
     ************* */

    // 입고 신청 => product 및 storage 관한 정보 받기
    public PartDto createStock(ProductDto productDto) {
        //무게를 측정해서 location 위치를 선별
        //입고할 productId와 동일한 Id 값을 식별
        return new PartDto();
    }

}