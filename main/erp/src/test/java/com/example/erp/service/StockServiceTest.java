package com.example.erp.service;

import com.example.erp.dto.PartDto;
import com.example.erp.entity.Part;
import com.example.erp.entity.Section;
import com.example.erp.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@SpringBootTest
public class StockServiceTest {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private StorageRepository storageRepository;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void dbTest() {
        //given
        List<Section> sectionList = sectionRepository.findAll();
        if (sectionList.isEmpty()) {
            log.info("section is empty");
        }
        for (Section section : sectionList) {
            log.info(section.getSectionId().toString());
        }

        List<Part> partList = partRepository.findAll();
        if (partList.isEmpty()) {
            log.info("partList is empty");
        }
        for (Part part : partList) {
            log.info(part.getPartId().toString());
        }

        Part part = partRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("no such part"));
        log.info(part.getPartId().toString());
    }

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
    //날짜별 보관 비용 도출 메서드
    public void sectionSeperating() {
        //given

        Part part = partRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("no such part"));

        int cost = 0;
        Section section = part.getSection();
        Date start = part.getStartStock();
        Date end = part.getEndStock();

        //날짜 차이 수 반환
        int date = (int) ((end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000));

        //section 크기별 분류
        if (section.getSectionId() > 0 && section.getSectionId() < 4) {
            cost = sectionSeperating(date);
            log.info(String.valueOf(cost));
        } else if (section.getSectionId() > 3 && section.getSectionId() < 6) {
            cost = sectionSeperating(date);
            log.info(String.valueOf(cost));
        } else if (section.getSectionId() > 5) {
            cost = sectionSeperating(date);
            log.info(String.valueOf(cost));
        } else {
            cost = sectionSeperating(date);
            System.out.println(cost);
        }
    }

    @Test
    @DisplayName("테스트 stockPartList")
    public void stockPartList(Long storageId) {
        List<Part> entitylist = partRepository.findBySection(
                sectionRepository.findByStorage(
                        storageRepository.findById(storageId).get()).get());
//                return  entitylist.stream()
//                .map((Part part) -> PartDto.toDto(part))
//                .collect(Collectors.toList());

        print((OutputStream) entitylist.stream()
                .map(PartDto::toDto)
                .toList());
    }

}