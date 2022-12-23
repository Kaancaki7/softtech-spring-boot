package com.softtech.softtechspringboot.learning.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "KULLANICI")
@Data
public class User {
    @Id    //id olduğunu belirtmelisin yoksa @Entity hata verir çalışması için primary key'e ihtiyaç duyar.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id'yi database'de 1-2 gibi yolladıkça sıralı şekilde vermesine yaradı.
    private Long id;
}
