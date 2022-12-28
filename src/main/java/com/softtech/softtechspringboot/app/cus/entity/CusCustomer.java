package com.softtech.softtechspringboot.app.cus.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CUS_CUSTOMER")
@Data
public class CusCustomer {
    @Id
    @SequenceGenerator(name = "CusCustomer",sequenceName = "CUS_CUSTOMER_ID_SEQ")
    @GeneratedValue(generator = "CusCustomer")
    private Long id;
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surName;
    @Column(name = "IDENTITY_NO", nullable = false)
    private Long identityNo;
    @Column(name = "PASSWORD", nullable = false)
    private String password;

}
