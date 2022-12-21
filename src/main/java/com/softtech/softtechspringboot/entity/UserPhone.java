package com.softtech.softtechspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;

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
