package com.softtech.softtechspringboot.app.acc.dao;

import com.softtech.softtechspringboot.app.acc.entity.AccAccount;
import com.softtech.softtechspringboot.app.gen.enums.GenStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccAccountDao extends JpaRepository<AccAccount, Long> {

    List<AccAccount> findAllByStatusType(GenStatusType statusType);
}
