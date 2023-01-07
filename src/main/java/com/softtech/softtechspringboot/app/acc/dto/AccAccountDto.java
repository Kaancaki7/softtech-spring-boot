package com.softtech.softtechspringboot.app.acc.dto;

import com.softtech.softtechspringboot.app.acc.enums.AccAccountType;
import com.softtech.softtechspringboot.app.acc.enums.AccCurrencyType;
import com.softtech.softtechspringboot.app.gen.enums.GenStatusType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
@Data
public class AccAccountDto {
    private Long cusCustomerId;
    private String ibanNo;
    private BigDecimal currentBalance;
    private AccCurrencyType currencyType;
    private AccAccountType accountType;
    private GenStatusType genStatusType;

}
