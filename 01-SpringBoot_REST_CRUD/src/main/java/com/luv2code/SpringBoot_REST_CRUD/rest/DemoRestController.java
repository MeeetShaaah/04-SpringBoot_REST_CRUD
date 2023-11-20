package com.luv2code.SpringBoot_REST_CRUD.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    // Add Code for /Hello
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
