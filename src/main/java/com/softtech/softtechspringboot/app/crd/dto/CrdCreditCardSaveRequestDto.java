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
    private BigDecimal earning;
    private String cutOffDay;
}
