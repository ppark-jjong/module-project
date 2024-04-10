package com.example.erp.service;

import com.example.erp.dto.*;
import com.example.erp.entity.*;
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

    // *! 해당 메서드들은 위치해야할 클래스에 배치되지 않은 경우가 다수 있음. 추후 리팩토링 필요할것


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

        if (productDto == null) throw new IllegalArgumentException("no product exist");
        // storage capacity 삭제 후 사용 가능 상태인지만을 나타내는 state 속성 추가를 고려해야할듯
        if (storageDto.getState() == 1) throw new IllegalArgumentException("full storage capacity");

        int productSize = Math.round(productDto.getSize());
        int sectionNum = calcSection(productSize);

        // select section by storage && sectionNumber. 추후 분리가 필요할 수도 있음.
        Section section = sectionRepository.findByStorageAndSectionNumber(storageDto.getStorageId(), sectionNum);
        if (!isSectionCapacityLeft(section)) throw new IllegalArgumentException("full section capacity");

        Part part = Part.builder()
                .section(section)
                .product(ProductDto.toEntity(productDto))
                .startStock(date)
                .build();

        PartDto partDto = PartDto.toDto(partRepository.save(part));

        return partDto;
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

    // section capacity 계산. 공간이 남을 시 true, 아니면 false 반환
    // 추후 사용처가 많지 않을 경우 메서드 병합 고려.
    public boolean isSectionCapacityLeft(Section section) {
        if (section.getCapacity() > Math.round(section.getCurrentCapacity())) return true;
        return false;
    }

    //
    public

}
