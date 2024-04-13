package com.example.erp.service;

import com.example.erp.entity.Part;
import com.example.erp.entity.Section;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@SpringBootTest
public class StockServiceTest {

    @MockBean
    private PartRepository partRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
    @DisplayName("테스트")
    //날짜별 보관 비용 도출 메서드
    public void sectionSeperating() {
        //given
        Optional<Part> part = partRepository.findById(1L);

        int cost = 0;
        Section section = part.get().getSection();
        Date start = part.get().getStartStock();
        Date end = part.get().getEndStock();

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