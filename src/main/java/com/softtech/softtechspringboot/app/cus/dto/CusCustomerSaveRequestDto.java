package com.softtech.softtechspringboot.app.cus.dto;

import lombok.Data;

@Data
public class CusCustomerSaveRequestDto {

    private String name;
    private String surName;
    private Long identityNo;
    private String password;
}
