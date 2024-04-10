package com.example.erp.service;

import com.example.erp.entity.Part;
import com.example.erp.entity.Section;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
public class StockServiceTest {

    @MockBean
    private PartRepository partRepository;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
            return 500 + 2000;
        } else {
            return 0;
        }
    }

    @Test
    @DisplayName("sectionSeperating method")
    //날짜별 보관 비용 도출 메서드
    public void sectionSeperating() {
        //given
        Part part = partRepository.getReferenceById(1L);

        int cost = 0;
        Section section = part.getSection();
        Date start = part.getStartStock();
        Date end = part.getEndStock();

        //날짜 차이 수 반환
        int date = (int) ((end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000));

        //section 크기별 분류
        if (section.getSectionId() > 0 && section.getSectionId() < 4) {
            cost = sectionSeperating(date);
            print(cost);
        } else if (section.getSectionId() > 3 && section.getSectionId() < 6) {
            cost = sectionSeperating(date);
            print(cost);
        } else if (section.getSectionId() > 5) {
            cost = sectionSeperating(date);
            print(cost);
        } else {
            cost = sectionSeperating(date);
            print(cost);
        }
    }

    private void print(int cost) {
    }
}