package com.softtech.softtechspringboot.service.entityservice;

import com.softtech.softtechspringboot.entity.User;
import com.softtech.softtechspringboot.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {
    @Autowired
    private UserDao userDao;

    public User save(User user) {
        return userDao.save(user);
    }
}
