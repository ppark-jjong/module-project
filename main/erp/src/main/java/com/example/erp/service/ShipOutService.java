package com.example.erp.service;

import com.example.erp.dto.DeliveryInForDto;
import com.example.erp.entity.*;
import com.example.erp.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
//출고에 관한 서비스
public class ShipOutService {

    private ProductRepository productRepository;
    private DeliveryInforRepository deliveryInforRepository;
    private ClientRepository clientRepository;
    private DeliveryTypeRepository deliveryTypeRepository;
    private DeliveryUserRepository deliveryUserRepository;
    private ShipmentRepository shipmentRepository;
    private ArrivalCityRepository arrivalCityRepository;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //    주문 생성
    public DeliveryInForDto createOrder(DeliveryInForDto deliveryInForDto) {
        Optional<Client> client = clientRepository.findByClientId(deliveryInForDto.getClientId());
        Optional<Product> product = productRepository.findById(deliveryInForDto.getProductId());
        Optional<ArrivalCity> arrivalCity =
                arrivalCityRepository.findById(deliveryInForDto.getArrivalCityId());

        if (client.isPresent() && product.isPresent() && arrivalCity.isPresent()) {

            DeliveryInfor deliveryInfor =
                    deliveryInForDto.toEntity(client.get(), product.get(), arrivalCity.get());
            deliveryInforRepository.save(deliveryInfor);

            return deliveryInForDto.toDto(deliveryInfor);
        }
        return null;
    }
//    주문 수정 (admin만 가능)


    //현재날짜 기준 생성된 주문 리스트 출력
    public List<DeliveryInForDto> findInForListInPerDay(Date date) {
        List<DeliveryInfor> entityList = deliveryInforRepository.findAllByEta(date);

    }

    //재고 찾기

//    public PartDto check


    //
//    public StorageDto findNearStorage() {
//
//    }

//}
}