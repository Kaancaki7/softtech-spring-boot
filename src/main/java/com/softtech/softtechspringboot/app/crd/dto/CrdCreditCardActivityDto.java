package com.softtech.softtechspringboot.app.crd.dto;

import com.softtech.softtechspringboot.app.crd.enums.CrdCreditCardActivityType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CrdCreditCardActivityDto {

    private Long crdCreditCardId;
    private BigDecimal amount;
    private Date transactionDate;
    private String description;
    private CrdCreditCardActivityType cardActivityType;
}
