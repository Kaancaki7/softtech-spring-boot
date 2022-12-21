package com.softtech.softtechspringboot.repository;

import com.softtech.softtechspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//şimdilik JpaRepository ile ilgili bilmemiz gereken en kapsamlı repository olmasıdır.
@Repository
public interface UserDao extends JpaRepository<User, Long> {


}
