package com.example.erp.service;

import com.example.erp.dto.*;
import com.example.erp.entity.*;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
//출고에 관한 서비스
public class ShipOutService {

    private final StorageRepository storageRepository;
    private final PartRepository partRepository;
    private ProductRepository productRepository;
    private DeliveryInforRepository deliveryInforRepository;
    private ClientRepository clientRepository;
    private DeliveryTypeRepository deliveryTypeRepository;
    private DeliveryUserRepository deliveryUserRepository;
    private ShipmentRepository shipmentRepository;
    private ArrivalCityRepository arrivalCityRepository;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ShipOutService(StorageRepository storageRepository, PartRepository partRepository) {
        this.storageRepository = storageRepository;
        this.partRepository = partRepository;
    }

    //    주문 생성
    public DeliveryInForDto createDeliveryInFor(DeliveryInForDto deliveryInForDto) {
        Optional<Client> client = clientRepository.findByClientId(deliveryInForDto.getClientId());
        Optional<Product> product = productRepository.findById(deliveryInForDto.getProductId());
        Optional<ArrivalCity> arrivalCity =
                arrivalCityRepository.findById(deliveryInForDto.getArrivalCityId());

        if (client.isPresent() && product.isPresent() && arrivalCity.isPresent()) {
            DeliveryInfor deliveryInfor =
                    deliveryInForDto.toEntity(client.get(), product.get(), arrivalCity.get());
            deliveryInforRepository.save(deliveryInfor);

            return DeliveryInForDto.toDto(deliveryInfor);
        }
        return null;
    }


    //   주문 수정 (admin만 가능)


    //현재날짜 기준 생성된 주문 리스트 출력 (오늘이 될 수도 있고 다른 날이 될 수도 있다 이건 컨트롤러에서 조정 (시간 순으로 order by))
    public List<DeliveryInForDto> findInForListInPerDay(Date date) {
        if (date == null) {
            return null;
        } else {
            List<DeliveryInfor> entityList = deliveryInforRepository.findAllByEta(date);

            return entityList.stream()
                    .map(DeliveryInForDto::toDto)
                    .collect(Collectors.toList());

        }
    }

    //    재고 파악 메서드 (주문과 일치하는 물품 재고 찾기 - storage값 지정으로 찾아줌)
    public PartDto checkPart(DeliveryInForDto deliveryInForDto) {
        Long arrivalCityId = deliveryInForDto.getArrivalCityId();
        Long currentProductDtoId = deliveryInForDto.getProductId();

        //특정 storage 찾기
        Optional<Storage> currentStorage = storageRepository.
                findByArrivalCity(arrivalCityRepository.findById(arrivalCityId).get());
        //특정 storage에 있는 part 찾기
        Optional<Part> currentPart = partRepository
                .findByProductAndStorage(productRepository
                        .findById(currentProductDtoId).get(), currentStorage.get());

        return currentPart.map(PartDto::toDto).orElse(null);
    }


    //먼저 탐색한 스토리지를 제외하고 파트 재고를 파악 후 그 파트가 있는 스토리지를 리턴
    public StorageDto findStockStorage(ProductDto productDto, Long storageId) {
        // 파라미터로 받은 스토리지를 제외시켜야함(먼저 탐색한 스토리지임) => order by storage Id
        List<Part> findStorageList = partRepository.findByPartExceptionStorage(storageId);


        Optional<Storage> storage = storageRepository.findById(
                PartDto.toDto(selectPart).getStorageId());

        return StorageDto.toDto(storage.get());
    }

    // 제일 가까운 스토리지를 리턴해주는 메서드
    public StorageDto findNearStorage(String destination) {
        
    }

}