package com.softtech.softtechspringboot.learning.dto;

//Lombok'tan bahsedilecek.
//Lombok ne işe yarar ; constructor ve getter setter metodları ile uğraşma diyor normalde oluştuyorduk hepsini. Ama
//lombok uğraşma diyor classın başına @Data ibaresini getir cons. getter setter vb. her şeyi ayarlıyor.

import lombok.*;

@Data
@Builder        //Builder design-pattern.
//@AllArgsConstructor ->   //Bu tüm argümanları eklediği cons. oluyor Long,String,String...
//@NoArgsConstructor  ->   // Bu da birtane boş cons. oluşturuyor. argümansız.
//@RequiredArgsConstructor -> //Bu da sadece final olan argümanlarla cons. oluşturuyor.
//özet olarak All -> hepsi için,   No -> Boş cons. ,  Required -> zorunlu argümanlar için oluşturur.
public class UserDtoWithLombok {

    private Long id;
    private String name;
    private String surname;
    private String password;
    private String role;
    private String eMail;


}


