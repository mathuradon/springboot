package com.in28minutes.jpa.hibernate.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @GetMapping("/hello")
    public String helloMethod(){
        return "Hello";
    }
}
