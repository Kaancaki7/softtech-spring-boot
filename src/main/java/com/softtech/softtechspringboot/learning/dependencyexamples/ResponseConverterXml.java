package com.softtech.softtechspringboot.learning.dependencyexamples;

import org.springframework.stereotype.Component;

@Component
//@Primary  -   Bunu Xml veya Json dan herhangi birisine koyarsan öncelik olarak hep bunu çalışıtıracak
//yani main classımızda çalıştığı zaman XML çıktısı görürürz XML de primary olduğu için
public class ResponseConverterXml implements ResponseConverter{

    @Override
    public void convert() {
        System.out.println("XML");
    }
}
