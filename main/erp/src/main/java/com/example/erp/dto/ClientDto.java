package com.example.erp.dto;

import com.example.erp.entity.Client;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClientDto {

    @Builder
    public ClientDto(String clientId, String password, String name, String tel, int type) {
        this.clientId = clientId;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.type = type;
    }

    private String clientId;

    private String password;

    private String name;

    private String tel;


    private int type;

    public ClientDto toDto(Client client) {
        return ClientDto.builder()
                .clientId(client.getClientId())
                .password(client.getPassword())
                .name(client.getName())
                .tel(client.getTel())
                .type(client.getType())
                .build();
    }

    public Client toEntity() {
        return Client.builder()
                .clientId(clientId)
                .password(password)
                .name(name)
                .tel(tel)
                .type(type)
                .build();
    }


}