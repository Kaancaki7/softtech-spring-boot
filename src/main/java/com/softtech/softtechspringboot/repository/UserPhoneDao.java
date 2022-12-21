package com.softtech.softtechspringboot.repository;

import com.softtech.softtechspringboot.entity.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhoneDao extends JpaRepository<UserPhone , Long> {
}
