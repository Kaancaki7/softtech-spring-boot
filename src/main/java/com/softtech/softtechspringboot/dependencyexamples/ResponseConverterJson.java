package com.softtech.softtechspringboot.dependencyexamples;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ResponseConverterJson implements ResponseConverter{

    @Override
    public void convert() {
        System.out.println("JSON");
    }
}
