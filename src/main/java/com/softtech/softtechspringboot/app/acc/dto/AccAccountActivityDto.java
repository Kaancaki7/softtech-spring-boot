package com.softtech.softtechspringboot.app.acc.dto;

import com.softtech.softtechspringboot.app.acc.enums.AccAccountActivityType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccAccountActivityDto {


    private Long AccAccountId;
    private BigDecimal amount;
    private Date transactionDate;
    private BigDecimal currentBalance;
    private AccAccountActivityType accountActivityType;
}
