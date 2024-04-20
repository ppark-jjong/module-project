package com.example.erp.service;

import com.example.erp.dto.*;
import com.example.erp.entity.*;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
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

    //재고 파악 메서드 (주문과 일치하는 물품 재고 찾기
//    public PartDto checkPart(DeliveryInforDto deliveryInforDto) {
//        Long arrivalCityId = deliveryInforDto.getArrivalCityId();
//        Long currentProductDtoId = deliveryInforDto.getProductId();
//
//
//
//

    public PartDto checkPart(DeliveryInforDto deliveryInforDto) {
        Long arrivalCityId = deliveryInforDto.getArrivalCityId();
        Long currentProductDtoId = deliveryInforDto.getProductId();

        Optional<Storage> currentStorage = storageRepository.
                findByArrivalCity(arrivalCityRepository.findById(arrivalCityId).get());
        Optional<Part> currentPart = partRepository.findByProduct_ProductIdAndStorage_StorageId(currentProductDtoId, currentStorage.get().getStorageId());

        if (currentPart.isPresent()) {
            return PartDto.toDto(currentPart.get());
        } else {
            return null;
        }
    }

//        Optional<Storage> currentStorage = storageRepository.
//                findByArrivalCity(arrivalCityRepository.findById(arrivalCityId).get());
////        Optional<Part> currentPart = partRepository
////                .findByProductAndStorage(currentProductDtoId, currentStorage.get().getStorageId());
//        if (currentPart.isPresent()) {
//            return PartDto.toDto(currentPart.get());
//        } else {
//            // 조금 더 먼 스토리지에 재고를 파악해야함
//            // 지역정보를 이용하여 조금 더 근처의 스토리지를 파악하는 메서드 필요
//            return null;
//        }
//    }


//    //먼저 탐색한 스토리지를 제외하고 파트 재고를 파악 후 그 파트가 있는 스토리지를 리턴
//    public StorageDto findNearStorage(ProductDto productDto, Long storageId) {
//        // 파라미터로 받은 스토리지를 제외시켜야함(먼저 탐색한 스토리지임)
//        List<Part> findStorageList = partRepository.findByPartExceptionStorage(storageId);
//
//        partRepository.findByProduct()
//    }


}