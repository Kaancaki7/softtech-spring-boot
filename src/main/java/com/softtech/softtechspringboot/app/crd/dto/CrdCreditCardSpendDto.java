package com.softtech.softtechspringboot.app.crd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@Data
public class CrdCreditCardSpendDto {

    private Long cardNo;
    private Long cvvNo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;
    private BigDecimal amount;
    private String description;

}
