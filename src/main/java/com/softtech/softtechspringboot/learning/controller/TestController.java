package com.softtech.softtechspringboot.learning.controller;

import org.springframework.web.bind.annotation.*;


//@RestController controller classlarının üzerine yazılır. Controller olduğunu belirtir.
//@RestController
//@RequestMapping("/api/v1/tests")
public class TestController {
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public void sayHello() {
        System.out.println("hello");
    }

    //direkt @GetMapping("/helloworld!") ile de yazdırabiliriz @RequestMapping'in method direkt yazılmış hali.
    @GetMapping("/HelloWorld!")
    public String sayHelloWorld() {

        String helloWorld = "Hello world!";
        System.out.println("Terminale yazdırıyoruz burada : " + "Hello World!");
        return helloWorld;
    }

    //post işlemini postman gibi araçlardan çağırabiliriz.
    @PostMapping
    public void save() {
        System.out.println("saved!");
    }

    //burada String person'u kendimiz verebilmek için path variable dan yardım aldık ve getMapping'in içine
    //tanımladık.Localhostumuzda -> localhost:8080/sayHello/Kaan/Çakı yazarsak bize çıktı olarak
    // hello Kaan Çakı verecektir.
    @GetMapping("/sayHello/{name}/{surname}")
    public String sayHello(@PathVariable String name, @PathVariable String surname) {

        //sout ile terminale Kaan Çakı bastırıyoruz sadece
        System.out.println(name + " " +  surname);

        return "hello " + name + " " + surname;
    }
}
