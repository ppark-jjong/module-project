package com.example.erp.service;

import com.example.erp.dto.PartDto;
import com.example.erp.entity.Part;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
public class StockServiceTest {

    @Autowired
    private PartRepository partRepository;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    //날짜별 보관 비용 도출 메서드
    public void sectionSeperating() {
        //각 section별 보관 비용 값
        int section1 = 500;
        int section2 = 1000;
        int section3 = 1200;
//
//        if (date > 0 && date < 8) {
//            return 500 + 300;
//        } else if (date > 8 && date < 31) {
//            return 500 + 1000;
//        } else if (date > 30) {
//            return 500 + 2000;
//        } else {
//            return 0;
//        }
    }


//    // 하나의 물품에 대한 보관 비용 계산 메서드
//    public int stockCostCalculation(PartDto partDto) {
//        int cost = 0;
//        long sectionId = partDto.getSectionId();
//        Date start = partDto.getStartStock();
//        Date end = partDto.getEndStock();
//
//        //날짜 차이 수 반환
//        int date = (int) ((end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000));
//
//        //section 크기별 분류
//        if (sectionId > 0 && sectionId < 4) {
//            return sectionSeperating(date);
//        } else if (sectionId > 3 && sectionId < 6) {
//            return sectionSeperating(date);
//        } else if (sectionId > 5) {
//            return sectionSeperating(date);
//        } else {
//            return 0;
//        }
//    }

}