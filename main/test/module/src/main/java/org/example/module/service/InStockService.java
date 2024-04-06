package org.example.module.service;

import org.example.module.dto.LocationDto;
import org.example.module.dto.PartDto;
import org.example.module.dto.ProductDto;
import org.example.module.dto.StorageDto;
import org.example.module.entity.Location;
import org.example.module.entity.Storage;
import org.example.module.repository.LocationRepository;
import org.example.module.repository.PartRepository;
import org.example.module.repository.ProductRepository;
import org.example.module.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public StorageDto selectStorageByName(String name) {
        Storage storage = storageRepository.findByName(name);
        StorageDto storageDto = new StorageDto();
        storageDto.insertEntity(storage);
        return storageDto;
    }

    public LocationDto selectLocationById(int id) {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isPresent()) {
            LocationDto locationDto = new LocationDto();
            locationDto.insertEntity(location.get());
            return locationDto;
        } else {
            return null;
        }
    }

    /* *************
        DB 정보 조회 끝
     ************* */


    @Transactional
    // 입고된 물품 분류 저장하기 => product 및 storage 관한 정보 받기
    public PartDto createStock(ProductDto insertProduct, String storageName) {
        ProductDto productDto = new ProductDto();

        //입고 신청한 storage 탐색
        StorageDto findStorageDto = selectStorageByName(storageName);

        //무게를 측정해서 location 위치를 선별
        int weight = productDto.getWeight();
        if (weight < 0) {
            if (weight < 6) {
                LocationDto findLocationDto = selectLocationById(1);
                return new PartDto(findLocationDto.toEntity(),
                        findStorageDto.toEntity(), productDto.toEntity());
            } else if (weight < 16) {
                LocationDto findLocationDto = selectLocationById(2);
                return new PartDto(findLocationDto.toEntity(),
                        findStorageDto.toEntity(), productDto.toEntity());
            } else if (weight < 26) {
                LocationDto findLocationDto = selectLocationById(3);
                return new PartDto(findLocationDto.toEntity(),
                        findStorageDto.toEntity(), productDto.toEntity());
            } else {
                LocationDto findLocationDto = selectLocationById(4);
                return new PartDto(findLocationDto.toEntity(),
                        findStorageDto.toEntity(), productDto.toEntity());

            }
        } else return null;
    }

    //입고할 productId와 동일한 Id 값을 식별 (나중에 많은 량 입고를 가정할 떄 추가 요망)



}
