package com.softtech.softtechspringboot.app.crd.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CrdCreditCardResponseDto {
    private Long id;
    private Long cardNo;
    private String test;
    private Long cvvNo;
    private Date expireDate;
    private BigDecimal totalLimit;
    private BigDecimal availableCardLimit;
    private BigDecimal currentDebt;
    private BigDecimal minimumPaymentAmount;
    private Date cutOffDate;
     private Date dueDate;

}
