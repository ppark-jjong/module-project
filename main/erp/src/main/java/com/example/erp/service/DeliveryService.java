package com.example.erp.service;

import com.example.erp.dto.*;
import com.example.erp.entity.DeliveryInfor;
import com.example.erp.entity.DeliveryType;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.h2.util.json.JSONObject;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Random;


@Service
@PropertySource("classpath:/application-API-KEY.properties")
public class DeliveryService {
    private final FindService findService;

    public DeliveryService(FindService findService) {
        this.findService = findService;
    }

    @Value("${kakao.admin.key}")
    private String kakao_admin_key;

    // 좌표값을 바탕으로 출발지 - 목적지 사이의 거리를 계산 (kakao api)
    public int getDistance(String originX, String originY, String destX, String destY) {
        int distance = 0;

        //Http 서버와 통신 가능한 자바 라이브러리. 응답을 JSON/xml 형식으로 변환 가능
        RestTemplate restTemplate = new RestTemplate();

        final String URL = "https://apis-navi.kakaomobility.com/v1/directions";

        // header 설정
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "KakaoAK " + kakao_admin_key);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        // 요청 파라미터 추가
        // get 방식이므로 Body를 사용하지 않을 것임
        // https://apis-navi.kakaomobility.com/v1/directions?origin=###&destination=###
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("origin", originX + "," + originY)
                .queryParam("destination", destX + "," + destY);

        // Http object 만들기
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        // Http 요청 후 리턴값 받기
        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),      // 요청 헤더
                HttpMethod.GET,             // 요청 방식
                entity,                     // http object
                String.class);              // return object

        String responseBody = response.getBody();
        System.out.println("Response = " + responseBody);

        // Gson 라이브러리 JSON 파싱 객체
        JsonParser jsonParser = new JsonParser();

        // JSON 데이터 파싱 과정
        JsonObject jsonObject = jsonParser.parse(responseBody).getAsJsonObject();
        JsonArray routesArray = jsonObject.getAsJsonArray("routes");
        JsonObject firstRoute = routesArray.get(0).getAsJsonObject();
        JsonObject summaryObject = firstRoute.getAsJsonObject("summary");

        distance = summaryObject.getAsJsonPrimitive("distance").getAsInt();

        return distance;
    }

    // 거리별 deliveryType 지정
    public Long getDeliveryType(String originX, String originY, String destX, String destY) {
        int distance = getDistance(originX, originY, destX, destY);
        Long deliveryType = null;

        if (distance >= 150000) {           // 150km
            deliveryType = 4L;
        } else if (distance > 100000) {     // 100km
            deliveryType = 3L;
        } else if (distance > 50000) {      // 50km
            deliveryType = 2L;
        } else if (distance > 20000) {      // 20km
            deliveryType = 1L;
        }

        return deliveryType;
    }



    // shipment 생성
    public ShipmentDto createShipment(DeliveryInforDto deliveryInforDto) {
        // 출발지 주소
        ArrivalCityDto storageLocation = findService.findArrivalCityById(
                findService.findStorageById(
                        findService.findPartByProductId(deliveryInforDto.getProductId()).getStorageId()
                ).getArrivalCity()
        );

        // 목적지 주소
        ArrivalCityDto clientLocation = findService.findArrivalCityById(deliveryInforDto.getArrivalCityId());

        Long deliveryType = getDeliveryType(storageLocation.getLongtitue(), storageLocation.getLattitue(),
                clientLocation.getLongtitue(), clientLocation.getLattitue());

        // 배송 기사 변수
        DeliveryType targetDeliveryType;

        // client 주소지에 부합하는 배송 기사 리스트 탐색
        List<DeliveryTypeDto> deliveryTypeDtoList = findService
                .findDeliveryTypeListByArrivalCityAndDeliveryType(clientLocation.getArrivalCityId(), deliveryType);

        // 리스트에서 조건 부합하는 배송 기사가 한 명 밖에 없을 시 바로 배정
        if (deliveryTypeDtoList.size() == 1) {
            DeliveryTypeDto deliveryTypeDto = deliveryTypeDtoList.get(0);
            targetDeliveryType = deliveryTypeDto.toEntity(
                    findService.findDeliveryUserById(deliveryTypeDto.getDeliveryUserId()).toEntity(),
                    findService.findArrivalCityById(deliveryTypeDto.getArrivalCityId()).toEntity()
            );
        } else if (deliveryTypeDtoList.size() > 1) {
            // 조건에 부합하는 배송 기사가 다수일 경우, 일단 랜덤 배정하였음
            Random random = new Random();
            int randomIndex = random.nextInt(deliveryTypeDtoList.size());
            DeliveryTypeDto deliveryTypeDto = deliveryTypeDtoList.get(randomIndex);
            targetDeliveryType = deliveryTypeDto.toEntity(
                    findService.findDeliveryUserById(deliveryTypeDto.getDeliveryUserId()).toEntity(),
                    findService.findArrivalCityById(deliveryTypeDto.getArrivalCityId()).toEntity()
            );
        } else if (deliveryTypeDtoList.isEmpty()) {
            // 고객 주소와 1:1로 매칭되는 정확한 배송 기사가 없는 경우

        }

    }
}
