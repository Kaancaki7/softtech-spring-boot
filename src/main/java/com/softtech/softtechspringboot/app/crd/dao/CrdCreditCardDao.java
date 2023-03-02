package com.softtech.softtechspringboot.app.crd.dao;

import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCard;
import com.softtech.softtechspringboot.app.gen.enums.GenStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;

import java.util.List;

@Repository
public interface CrdCreditCardDao extends JpaRepository<CrdCreditCard, Long> {

    List<CrdCreditCard> findAllByStatusType(GenStatusType statusType);

    CrdCreditCard findByCardNoAndCvvNoAndExpireDate(Long cardNo, Long cvvNo, Date expireDate);
}
