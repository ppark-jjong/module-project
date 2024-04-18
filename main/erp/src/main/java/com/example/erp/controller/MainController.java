package com.example.erp.controller;

import com.example.erp.service.WarehousingService;
import com.sun.tools.javac.Main;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/test1")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello");
    }
}