package com.example.erp.service;

import com.example.erp.dto.PartDto;
import com.example.erp.entity.Part;
import com.example.erp.entity.Section;
import com.example.erp.entity.Storage;
import com.example.erp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StockService {

    private final StorageRepository storageRepository;
    private final SectionRepository sectionRepository;
    private final ProductRepository productRepository;
    private final PartRepository partRepository;
    private final NewStockRepository newStockRepository;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public StockService(StorageRepository storageRepository,
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

    //날짜별 보관 비용 도출 메서드
    public int sectionSeperating(int date) {
        //각 section별 보관 비용 값
        int section1 = 500;
        int section2 = 1000;
        int section3 = 1200;

        if (date > 0 && date < 8) {
            return 500 + 300;
        } else if (date > 8 && date < 31) {
            return 500 + 1000;
        } else if (date > 30) {
            return 500 + 2000 ;
        } else {
            return 0;
        }
    }


    // 하나의 물품에 대한 보관 비용 계산 메서드
    public int stockCostCalculation(PartDto partDto) {
        int cost = 0;
        long sectionId = partDto.getSectionId();
        Date start = partDto.getStartStock();
        Date end = partDto.getEndStock();

        //날짜 차이 수 반환
        int date = (int) ((end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000));

        //section 크기별 분류
        if (sectionId > 0 && sectionId < 4) {
            return sectionSeperating(date);
        } else if (sectionId > 3 && sectionId < 6) {
            return sectionSeperating(date);
        } else if (sectionId > 5) {
            return sectionSeperating(date);
        } else {
            return 0;
        }
    }

    // 특정 날짜에 특정 스토리지에서 계산해야하는 물품 보관 비용 계산 메서드
    public int stockCostCalculationDate(long storageId, String date) throws ParseException {
        Date nowDate = dateFormat.parse(date);
        List<Part> partList = partRepository.findByStorageIdAndDate(sectionRepository.
                findByStorage(storageRepository.findById(storageId)), nowDate);
        for(int i = 0 ; i < storageId ; i++) {}
    }
}