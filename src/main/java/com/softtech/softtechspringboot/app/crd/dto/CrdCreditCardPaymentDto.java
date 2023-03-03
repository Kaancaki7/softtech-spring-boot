package com.softtech.softtechspringboot.app.crd.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CrdCreditCardPaymentDto {

    private Long crdCreditCardId;
    private BigDecimal amount;
}
