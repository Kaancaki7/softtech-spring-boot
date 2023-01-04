package com.softtech.softtechspringboot.app.acc.dao;

import com.softtech.softtechspringboot.app.acc.entity.AccAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccAccountDao extends JpaRepository<AccAccount, Long> {

}
