package com.softtech.softtechspringboot.app.acc.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccMoneyActivityRequestDto {

    private Long accAccountId;
    private BigDecimal amount;

}
