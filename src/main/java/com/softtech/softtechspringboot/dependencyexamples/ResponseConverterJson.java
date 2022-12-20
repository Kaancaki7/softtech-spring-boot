package com.softtech.softtechspringboot.dependencyexamples;

import org.springframework.stereotype.Component;

@Component
public class ResponseConverterJson implements ResponseConverter{

    @Override
    public void convert() {
        System.out.println("JSON");
    }
}
