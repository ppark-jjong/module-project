package com.example.erp.service;

import com.example.erp.dto.*;
import com.example.erp.entity.NewStock;
import com.example.erp.entity.Product;
import com.example.erp.entity.Section;
import com.example.erp.entity.Storage;
import com.example.erp.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehousingService {

    private final StorageRepository storageRepository;
    private final SectionRepository sectionRepository;
    private final ProductRepository productRepository;
    private final PartRepository partRepository;
    private final NewStockRepository newStockRepository;

    @Autowired
    public WarehousingService(StorageRepository storageRepository,
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

    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // 새로운 입고 물품 신청
    @Transactional
    public NewStockDto createNewStock(long storageId, long productId, int count) {

        // 반환 Optional 이딴식으로 하면 메서드 종료 후 어딘가에서 반드시 try catch 예외 처리를 받아야 할텐데
        // 이게 맞나
        Storage storage = storageRepository.findById(storageId)
                .orElseThrow(() -> new IllegalArgumentException("스토리지 없당"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("제품 없당"));


        NewStock newStock = NewStock.builder()
                .storage(storage)
                .product(product)
                .count(count)
                .stockDate(date)
                .build();

        NewStockDto newStockDto = new NewStockDto();
        newStockDto.toDto(newStockRepository.save(newStock));
        return newStockDto;
    }

    // 파라미터의 스토리지에 금일 보관되는 product 및 개수
    public List<NewStockDto> countInStockInStorage(long storageId) {
        return newStockRepository.findAllByStorage(storageId).stream()
                .filter(newStock -> newStock.getStockDate() == date)
                .map(NewStockDto::new)
                .collect(Collectors.toList());
    }

    // part 생성 메서드
    public PartDto inStock(ProductDto productDto, StorageDto storageDto) {

        if (productDto == null) new IllegalArgumentException("no product exist");
        if (Math.round(storageDto.getCurrentCapacity()) >= storageDto.getCapacity()) throw new IllegalArgumentException("full storage capacity");

        int productSize = Math.round(productDto.getSize());
        int sectionNum = calcSection(productSize);

        // select section by storage && sectionNumber. 추후 분리가 필요할 수도 있음.
        Section section = sectionRepository.findByStorageAndSectionNumber(storageDto.getStorageId(), sectionNum);

        SectionDto targetSectionDto = SectionDto.toDto(section);


        // sectionDto의 매개변수 없는 생성자가 protect 범위로 설정됨. setter 주입과 무분별한 객체 생성을 억제하였으나
        // Entity -> Dto 변환 간에서 객체 생성의 문제가 발생함.

    }

    // product size를 바탕으로 section을 할당해주는 계산 메서드. 가시성을 위해 분리함
    public int calcSection(int productSize) {
        int sectionNum = 0;

        if (productSize < 0) throw new IllegalArgumentException("negative product size");

        if (productSize == 0) {
            sectionNum = 6;
            return sectionNum;
        }

        if (productSize > 0 && productSize >= 20) {
            sectionNum = 1;
        } else if (productSize > 20 && productSize <= 50) {
            sectionNum = 2;
            return sectionNum;
        } else if (productSize > 50 && productSize <= 100) {
            sectionNum = 3;
        }  else if (productSize > 100 && productSize <= 200) {
            sectionNum = 4;
        } else if (productSize > 200) {
            sectionNum = 5;
        }
        return sectionNum;
    }

}
