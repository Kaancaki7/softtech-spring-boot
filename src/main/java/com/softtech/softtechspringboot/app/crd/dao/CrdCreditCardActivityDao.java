package com.softtech.softtechspringboot.app.crd.dao;

import com.softtech.softtechspringboot.app.crd.entity.CrdCreditCardActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface CrdCreditCardActivityDao extends JpaRepository<CrdCreditCardActivity, Long> {

    List<CrdCreditCardActivity> findAllByCrdCreditCardIdAndTransactionDateBetween(Long crdCreditCardId, Date startDate, Date endDate);
}
