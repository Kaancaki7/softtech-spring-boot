package com.softtech.softtechspringboot.app.acc.dao;

import com.softtech.softtechspringboot.app.acc.entity.AccMoneyTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccMoneyTransferDao extends JpaRepository<AccMoneyTransfer, Long> {
}
