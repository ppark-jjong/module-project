package com.example.erp.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
@PropertySource("classpath:/application-API-KEY.properties")
public class DeliveryService {
    @Value("${kakao.admin.key}")
    private String kakao_admin_key;

    public int getDistance(String originX, String originY, String destX, String destY ) {
        int distance = 0;

        HttpHeaders httpHeaders = new HttpHeaders();

        //Http 서버와 통신 가능한 자바 라이브러리. 응답을 JSON/xml 형식으로 변환 가능
        RestTemplate restTemplate = new RestTemplate();

        final String URL = "https://apis-navi.kakaomobility.com/v1/directions";

        // header 설정
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
}

