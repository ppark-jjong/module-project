package com.example.erp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
// 사후처리를 위한 서비스 + 주문이 들어오는 순간 부터 주문의 진행 상태를 확인할 수 있는 단계
public class PODService {
//    pod 생성 (order 생성 시 바로 생성)
    // status == 주문 확인

//    pod 상태 변경
    // status == 재고 확인 중


//    pod 상태 변경
    // status == 주문 접수
    // time == part 찾기가 끝나는 시간

//    pod 상태 변경
    // status == 배송 대기 중
    // time == 클라이언트에서 적용된 http 메서드 발생 시 상태 변경

//    pod 상태 변경
    // status == 배송 중
    // time == shipment가 시작된 시간

//    pod 상태 변경
    // status == 배송 완료
    // time == shipment가 끝난 시간
}