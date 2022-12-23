package com.softtech.softtechspringboot.learning.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_PHONE")
@Data
public class UserPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String phoneNumber;
}
