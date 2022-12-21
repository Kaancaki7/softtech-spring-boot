package com.softtech.softtechspringboot.service.entityservice;

import com.softtech.softtechspringboot.entity.UserPhone;
import com.softtech.softtechspringboot.entity.UserPhone;
import com.softtech.softtechspringboot.repository.UserDao;
import com.softtech.softtechspringboot.repository.UserPhoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPhoneEntityService {

    @Autowired
    private UserPhoneDao userPhoneDao;

    public UserPhone save(UserPhone user) {
        return userPhoneDao.save(user);
    }
}
