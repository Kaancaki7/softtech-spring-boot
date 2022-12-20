package com.softtech.softtechspringboot.dependencyexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class WebService {
    @Autowired
    //@Qualifier("xml) or @Qualifier("json") buraya hangisini yazarsan default olarak onu baz alarak çıktısını verir.
    private ResponseConverter responseConverter;

    public void convertResponse() {
        responseConverter.convert();
    }
}
