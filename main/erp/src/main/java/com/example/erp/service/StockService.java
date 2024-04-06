package com.example.erp.service;

import com.example.erp.dto.NewStockDto;
import com.example.erp.entity.NewStock;
import com.example.erp.repository.NewStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {

    private final NewStockRepository newStockRepository;

    @Autowired
    public StockService(NewStockRepository newStockRepository) {
        this.newStockRepository = newStockRepository;
    }


//    public List<NewStockDto> createNewStock(NewStockDto newStockDto) {
//        NewStock newStock = newStockDto.toEntity();
//        newStockRepository.save(newStock);
//        굳이 스트림 형식이 필요 없지만 (List를 query문 한번만 조회하기 때문) 그냥 연습
//        return newStockRepository.findAll().stream().
//                map(NewStockDto::new)
//                .collect(Collectors.toList());
//            List<NewStockDto> newStockDtos = newStockRepository.findAll().stream().
//                    map(o-> new NewStockDto(o))
//                    .collect(Collectors.toList());


//    }
}