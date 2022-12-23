package com.softtech.softtechspringboot.learning.repository;

import com.softtech.softtechspringboot.learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//şimdilik JpaRepository ile ilgili bilmemiz gereken en kapsamlı repository olmasıdır.
@Repository
public interface UserDao extends JpaRepository<User, Long> {


}
