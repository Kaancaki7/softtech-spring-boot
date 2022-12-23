package com.softtech.softtechspringboot.learning.repository;

import com.softtech.softtechspringboot.learning.entity.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhoneDao extends JpaRepository<UserPhone , Long> {
}
