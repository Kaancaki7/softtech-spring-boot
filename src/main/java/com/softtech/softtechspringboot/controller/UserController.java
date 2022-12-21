package com.softtech.softtechspringboot.controller;

import com.softtech.softtechspringboot.entity.UserPhone;
import com.softtech.softtechspringboot.entity.User;
import com.softtech.softtechspringboot.service.entityservice.UserEntityService;
import com.softtech.softtechspringboot.service.entityservice.UserPhoneEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private UserPhoneEntityService userPhoneEntityService;

    @PostMapping
    public User save(){

        User user = new User();

        user = userEntityService.save(user);

        return user;
    }
    @PostMapping("/phones")
    public UserPhone savePhone(){

        UserPhone userPhone = new UserPhone();

        userPhone.setUserId(1L);
        userPhone.setPhoneNumber("2381237123");

        userPhone = userPhoneEntityService.save(userPhone);

        return userPhone;
    }
}
