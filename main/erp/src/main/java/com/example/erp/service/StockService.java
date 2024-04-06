//package com.example.erp.service;
//
//import com.example.erp.dto.NewStockDto;
//import com.example.erp.dto.PartDto;
//import com.example.erp.dto.ProductDto;
//import com.example.erp.entity.*;
//import com.example.erp.repository.*;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//import java.util.Optional;
//
//@Service
//public class StockService {
//
//    private final StorageRepository storageRepository;
//    private final SectionRepository sectionRepository;
//    private final ProductRepository productRepository;
//    private final PartRepository partRepository;
//    private final NewStockRepository newStockRepository;
//
//
//    @Autowired
//    public StockService(StorageRepository storageRepository,
//                        SectionRepository sectionRepository,
//                        ProductRepository productRepository,
//                        PartRepository partRepository,
//                        NewStockRepository newStockRepository) {
//        this.storageRepository = storageRepository;
//        this.sectionRepository = sectionRepository;
//        this.productRepository = productRepository;
//        this.partRepository = partRepository;
//        this.newStockRepository = newStockRepository;
//    }
//
//    @Transactional
//    public NewStockDto createNewStock(long storageId, long productId, int count) {
//
//        // 반환 Optional 이딴식으로 하면 메서드 종료 후 어딘가에서 반드시 try catch 예외 처리를 받아야 할텐데
//        // 이게 맞나
//        Storage storage = storageRepository.findById(storageId)
//                .orElseThrow(() -> new IllegalArgumentException("스토리지 없당"));
//
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new IllegalArgumentException("제품 없당"));
//
//        NewStock newStock = NewStock.builder()
//                .storage(storage)
//                .product(product)
//                .count(count)
//                .build();
//
//        NewStockDto newStockDto = new NewStockDto();
//        newStockDto.toNewStockDto(newStockRepository.save(newStock));
//        return newStockDto;
//    }
//
//
//    DB 수정
//    public PartDto inStock(ProductDto productDto, long arrivalCity) {
//
//        long sectionId;
//        Product targetProduct;
//
//        Optional<Product> product = productRepository.findById(productDto.getId());
//        if (product.isPresent()) { product.get(); }
//
//        Optional<Storage> storage = storageRepository.findByArrivalCity(arrivalCity);
//        if (storage.isPresent()) { storage.get(); }
//
//
//        // section 배정
//        if ( productDto.getPrice() >= 1000) {
//            sectionId = 6;
//        }
//
//        float productSize = productDto.getSize();
//        if (productSize >= 1 && productSize < 20) {
//            sectionId = 1;
//        } else if (productSize >= 20 && productSize < 50) {
//            sectionId = 2;
//        } else if (productSize >= 50 && productSize < 100) {
//            sectionId = 3;
//        } else if (productSize >= 100 && productSize < 200) {
//            sectionId = 4;
//        } else if (productSize >= 200) {
//            sectionId = 5;
//        }
//
//    }
//}
