package com.example.erp.controller;

import com.example.erp.dto.NewStockDto;
import com.example.erp.dto.PartDto;
import com.example.erp.dto.ProductDto;
import com.example.erp.dto.StorageDto;
import com.example.erp.service.WarehousingService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class WarehousingController {
    @Autowired
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
    public ResponseEntity<PartDto> createPart(@RequestParam long storageId,
                                              @RequestParam long productId) {
        PartDto partDto = warehousingService.inStock(storageId, productId);
        return ResponseEntity.ok(partDto);
    }

}