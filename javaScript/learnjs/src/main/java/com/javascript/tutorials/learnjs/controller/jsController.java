package com.javascript.tutorials.learnjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/js")
public class jsController {
    
    @GetMapping("/alert")
    public String sayHello() {
        return "thHtml/alert-js";
    }

    @GetMapping("/vars")
    public String vars() {
        return "thHtml/vars-js";
    }

    @GetMapping("/objects")
    public String objects() {
        return "thHtml/object-js";
    }
}
