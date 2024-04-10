//package com.example.erp.repository;
//
//import com.example.erp.entity.Part;
//import com.example.erp.entity.Product;
//import com.example.erp.entity.Section;
//import jakarta.persistence.Table;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//
//@DataJpaTest
//@Transactional
//@TestPropertySource(locations = "classpath:application-test.yml")
//public class PartRepositoryTest {
////    List<Part> findByStorageIdAndDate(Section section, Date nowdate);
//
//    @Autowired
//    private PartRepository partRepository;
//
//    @Autowired
//
//    @Test
//    public void insertData() {
//        return Part.builder()
//                .section(1)
//                .product(2)
//                .startStock(2024-04-01)
//                .endStock(2024-04-09)
//                .build();
//    }
//}
