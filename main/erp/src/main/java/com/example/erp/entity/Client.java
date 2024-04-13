package com.example.erp.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "client")
@Getter
@NoArgsConstructor
public class Client {

    @Builder

    public Client(String clientId, String password, String name, String tel, String address, int type) {
        this.clientId = clientId;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.type = type;
    }

    @Id
    @Column(name = "client_id")
    private String clientId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "tel")
    private String tel;

    @Column(name = "address")
    private String address;

    @Column(name = "type")
    private int type;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<DeliveryInfor> deliveryInforList;

}
