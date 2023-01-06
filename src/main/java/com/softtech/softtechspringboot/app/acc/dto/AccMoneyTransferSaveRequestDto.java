package com.softtech.softtechspringboot.app.acc.dto;

import com.softtech.softtechspringboot.app.acc.enums.AccMoneyTransferType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class AccMoneyTransferSaveRequestDto {

    private Long accountIdFrom;
    private Long accountIdTo;
    private BigDecimal amount;
    private String description;
    private AccMoneyTransferType moneyTransferType;

}
