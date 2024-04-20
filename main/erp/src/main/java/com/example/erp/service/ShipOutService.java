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


    //   kd주문 수정 (admin만 가능)


    //현재날짜 기준 생성된 주문 리스트 출력 (오늘이 될 수도 있고 다른 날이 될 수도 있다 이건 컨트롤러에서 조정)
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

    //재고 찾기
<<<<<<< HEAD
//    public PartDto checkPart(DeliveryInForDto deliveryInForDto) {
//        Long arrivalCityId = deliveryInForDto.getArrivalCityId();
//        Long currentProductDtoId = deliveryInForDto.getProductId();
//
//
//
//
//    }
=======
    public PartDto checkPart(DeliveryInForDto deliveryInForDto) {
        Long arrivalCityId = deliveryInForDto.getArrivalCityId();
        Long currentProductDtoId = deliveryInForDto.getProductId();

        Optional<Storage> currentStorage = storageRepository.
                findByArrivalCity(arrivalCityRepository.findById(arrivalCityId).get());
        Optional<Part> currentPart = partRepository.findByProductAndStorage(currentProductDtoId, currentStorage.get().getStorageId());

        if (currentPart.isPresent()) {
            return PartDto.toDto(currentPart.get());
        } else {
            return null;
        }
    }
>>>>>>> upstream/main


    //
//    public StorageDto findNearStorage() {
//
//    }

//}
}