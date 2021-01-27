package com.javascript.tutorials.learnjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String sayHello() {
        return "home-page";
    }
}
