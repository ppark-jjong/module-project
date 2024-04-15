package com.example.erp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Setter;

@Setter
public class ClientDto {

    @Builder
    public ClientDto(String clientId, String password, String name, String tel, String address, int type) {
        this.clientId = clientId;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.type = type;
    }
    private String clientId;

    private String password;

    private String name;

    private String tel;

    private String address;

    private int type;





}