package com.example.erp.service;

import com.example.erp.dto.*;
import com.example.erp.entity.*;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

    private final DeliveryService deliveryService;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ShipOutService(StorageRepository storageRepository, PartRepository partRepository, DeliveryService deliveryService) {
        this.storageRepository = storageRepository;
        this.partRepository = partRepository;
        this.deliveryService = deliveryService;
    }

    //    주문 생성
    public DeliveryInforDto createDeliveryInfor(DeliveryInforDto deliveryInforDto) {
        Optional<Client> client = clientRepository.findByClientId(deliveryInforDto.getClientId());
        Optional<Product> product = productRepository.findById(deliveryInforDto.getProductId());
        Optional<ArrivalCity> arrivalCity =
                arrivalCityRepository.findById(deliveryInforDto.getArrivalCityId());

        if (client.isPresent() && product.isPresent() && arrivalCity.isPresent()) {
            DeliveryInfor deliveryInfor =
                    deliveryInforDto.toEntity(client.get(), product.get(), arrivalCity.get());
            deliveryInforRepository.save(deliveryInfor);

            return DeliveryInforDto.toDto(deliveryInfor);
        }
        return null;
    }


    //   주문 수정 (admin만 가능)


    //현재날짜 기준 생성된 주문 리스트 출력 (오늘이 될 수도 있고 다른 날이 될 수도 있다 이건 컨트롤러에서 조정 (시간 순으로 order by))
    public List<DeliveryInforDto> findInForListInPerDay(Date date) {
        if (date == null) {
            return null;
        } else {
            List<DeliveryInfor> entityList = deliveryInforRepository.findAllByEta(date);

            return entityList.stream()
                    .map(DeliveryInforDto::toDto)
                    .collect(Collectors.toList());

        }
    }

    //    재고 파악 메서드 (주문과 일치하는 물품 재고 찾기 - storage값 지정으로 찾아줌)
    public PartDto checkPart(DeliveryInforDto deliveryInForDto) {
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


    //먼저 탐색한 스토리지를 제외하고 주문의 Product가 있는 Storage들 중 가장 가까운 Storage 리턴
    //파라미터로 현재 주문의 part와
    public StorageDto findStockStorage(PartDto partDto, String x, String y) {
        // 파라미터로 part에는 먼저 탐색한 storage가 있으므로 이를 기준으로 쿼리를 돌림
        List<Part> findStorageList = partRepository.findByPartExceptionStorage(partDto.getStorageId(), partDto.getProductId());

        // 지역변수  초기화
        int result = 0;
        Part currentStorage = null;

        // 각각의 파트에 있는 스토리지의 주소를 파라미터로 넣어 좌표 값을 리턴 받는 메서드
        for (Part part : findStorageList) {
            String currentX = StorageDto.toDto(part.getStorage()).getX();
            String currentY = StorageDto.toDto(part.getStorage()).getY();

            int difference = deliveryService.getDistance(currentX, currentY, x, y);
            if (difference > result) {
                result = difference;
                currentStorage = part;
            }
        }
        if (currentStorage == null) {
            log.info("가까운 스토리지 찾기 실패 part 재고를 확인하거나, 로직  오류");
            return null;
        } else {
            return StorageDto.toDto(currentStorage.getStorage());
        }
    }


}