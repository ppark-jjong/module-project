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
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    public StockServiceTest(PartRepository partRepository, SectionRepository sectionRepository, StorageRepository storageRepository) {
        this.partRepository = partRepository;
        this.sectionRepository = sectionRepository;
        this.storageRepository = storageRepository;
    }

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


    @Test
    @DisplayName("테스트 stockPartList")
    public void stockPartList() {
        Long storageId = 1L;
        List<Part> entitylist = partRepository.findBySection(
                sectionRepository.findByStorage(
                        storageRepository.findById(storageId).get()).get());
//                return  entitylist.stream()
//                .map((Part part) -> PartDto.toDto(part))
//                .collect(Collectors.toList());
        List<PartDto> dtoList = entitylist.stream()
                .map(PartDto::toDto)
                .collect(Collectors.toList());
        System.out.println(dtoList);
    }
}