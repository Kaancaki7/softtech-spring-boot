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
    @Column(name = "ID_ACC_ACCOUNT")
    private Long AccAccountId;
    @Column(name = "AMOUNT",precision = 19,scale = 2)
    private BigDecimal amount;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;
    @Column(name = "CURRENT_BALANCE",precision = 19,scale = 2)
    private BigDecimal currentBalance;
    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_ACTIVITY_TYPE",length = 30)
    private AccAccountActivityType accountActivityType;
}
