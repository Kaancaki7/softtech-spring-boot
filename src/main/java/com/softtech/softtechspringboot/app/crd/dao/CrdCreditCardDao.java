package com.softtech.softtechspringboot.app.crd.dao;

import com.softtech.softtechspringboot.app.crd.dto.CrdCreditCardDetailsDto;
import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCard;
import com.softtech.softtechspringboot.app.gen.enums.GenStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;

import java.util.List;

@Repository
public interface CrdCreditCardDao extends JpaRepository<CrdCreditCard, Long> {

    List<CrdCreditCard> findAllByStatusType(GenStatusType statusType);

    CrdCreditCard findByCardNoAndCvvNoAndExpireDateAndStatusType(Long cardNo, Long cvvNo, Date expireDate, GenStatusType statusType);

    @Query(
            "select " +
                    "new com.softtech.softtechspringboot.app.crd.dto.CrdCreditCardDetailsDto(" +
                    "cusCustomer.name," +
                    "cusCustomer.surName," +
                    "crdCreditCard.cardNo," +
                    "crdCreditCard.expireDate," +
                    "crdCreditCard.currentDebt," +
                    "crdCreditCard.minimumPaymentAmount," +
                    "crdCreditCard.cutOffDate," +
                    "crdCreditCard.dueDate" +
                    ")" +
                    " from CrdCreditCard crdCreditCard left join CusCustomer cusCustomer on crdCreditCard.cusCustomerId = cusCustomer.id " +
            "where crdCreditCard.id = :creditCardId "
    )
    CrdCreditCardDetailsDto getCreditCardDetails(Long creditCardId);
}
