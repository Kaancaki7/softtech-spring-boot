package com.softtech.softtechspringboot.app.crd.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class CrdCreditCardSpendDto {

    private Long cardNo;
    private Long cvvNo;
    private Date expireDate;
    private BigDecimal amount;
    private String description;

}
