package com.softtech.softtechspringboot.app.acc.entity;

import com.softtech.softtechspringboot.app.acc.enums.AccMoneyTransferType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ACC_MONEY_TRANSFER")
@Getter
@Setter
public class AccMoneyTransfer {
    @Id
    @SequenceGenerator(name = "AccMoneyTransfer",sequenceName = "ACC_MONEY_TRANSFER_ID_SEQ")
    @GeneratedValue(generator = "AccMoneyTransfer")
    private Long id;
    @Column(name = "ID_ACC_ACCOUNT_FROM")
    private Long accountIdFrom;
    @Column(name = "ID_ACC_ACCOUNT_TO")
    private Long accountIdTo;
    @Column(name = "AMOUNT",precision = 19,scale = 2)
    private BigDecimal amount;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSFER_DATE")
    private Date transferDate;
    @Column(name = "DESCRIPTION",length = 100)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "MONEY_TRANSFER_TYPE",length = 30)
    private AccMoneyTransferType moneyTransferType;


}
