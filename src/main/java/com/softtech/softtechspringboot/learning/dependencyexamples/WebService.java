package com.softtech.softtechspringboot.learning.dependencyexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;



@Service
@Scope
public class WebService {
    @Autowired
    //@Qualifier("xml) or @Qualifier("json") buraya hangisini yazarsan default olarak onu baz alarak çıktısını verir.
    private ResponseConverter responseConverter;

    public void convertResponse() {
        responseConverter.convert();
    }

    public ResponseConverter getResponseConverter() {
        return responseConverter;
    }
}
