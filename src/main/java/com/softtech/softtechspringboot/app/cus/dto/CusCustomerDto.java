package com.softtech.softtechspringboot.app.cus.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
public class CusCustomerDto {

    private Long id;
    private String name;
    private String surName;
    private Long identityNo;

}
