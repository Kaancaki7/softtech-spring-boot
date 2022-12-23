package com.softtech.softtechspringboot.learning.controller;

import com.softtech.softtechspringboot.learning.entity.UserPhone;
import com.softtech.softtechspringboot.learning.entity.User;
import com.softtech.softtechspringboot.learning.exception.UserNotFoundException;
import com.softtech.softtechspringboot.learning.service.entityservice.UserEntityService;
import com.softtech.softtechspringboot.learning.service.entityservice.UserPhoneEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity save(){

        User user = new User();

        user = userEntityService.save(user);

        return new ResponseEntity(user, HttpStatus.CREATED);
    }
    @PostMapping("/phones")
    public UserPhone savePhone(){

        if (1 == 1) {
            throw new UserNotFoundException("user not found!");
        }

        UserPhone userPhone = new UserPhone();

        userPhone.setUserId(1L);
        userPhone.setPhoneNumber("2381237123");

        userPhone = userPhoneEntityService.save(userPhone);

        return userPhone;
    }
}
