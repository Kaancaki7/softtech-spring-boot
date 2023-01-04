package com.softtech.softtechspringboot.app.acc.entity;

import com.softtech.softtechspringboot.app.acc.enums.AccAccountActivityType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ACC_ACCOUNT_ACTIVITY")
@Getter
@Setter
public class AccAccountActivity {
    @Id
    @GeneratedValue(generator = "AccAccountActivity")
    @SequenceGenerator(name = "AccAccountActivity", sequenceName = "ACC_ACCOUNT_ACTIVITY_ID_SEQ")
    private Long id;

    private Long AccAccountId;
    private BigDecimal amount;
    private Date transactionDate;
    private BigDecimal currentBalance;
    private AccAccountActivityType accountActivityType;
}
