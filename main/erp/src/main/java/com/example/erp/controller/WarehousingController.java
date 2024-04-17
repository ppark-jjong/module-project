package com.example.erp.controller;

import com.example.erp.dto.NewStockDto;
import com.example.erp.dto.PartDto;
import com.example.erp.dto.ProductDto;
import com.example.erp.dto.StorageDto;
import com.example.erp.service.WarehousingService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/warehousing")
public class WarehousingController {
    private final WarehousingService warehousingService;

    public WarehousingController(WarehousingService warehousingService) {
        this.warehousingService = warehousingService;
    }

    @PostMapping("/create/newstock")
    public ResponseEntity<NewStockDto> createNewStock(@RequestBody NewStockDto newStockDto) {
        NewStockDto response = warehousingService.createNewStock(newStockDto.getStorageId(), newStockDto.getProductId(), newStockDto.getCount());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create/stock")
    public ResponseEntity<PartDto> createPart(@RequestBody ProductDto productDto, StorageDto storageDto) {
        PartDto partDto = warehousingService.inStock(productDto, storageDto);
        return ResponseEntity.ok(partDto);
    }

}