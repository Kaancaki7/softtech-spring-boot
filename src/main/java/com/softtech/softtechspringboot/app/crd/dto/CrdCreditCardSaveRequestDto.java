package com.softtech.softtechspringboot.app.crd.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CrdCreditCardSaveRequestDto {
    @NotNull
    private Long cusCustomerId;
    @NotNull
    private Long cardNo;
    @NotNull
    private Long cvvNo;
    private BigDecimal totalLimit;
    private BigDecimal availableCardLimit;
    private BigDecimal currentDebt;
    private BigDecimal minimumPaymentAmount;
    private Date cutOffDate;
    private Date dueDate;
}
