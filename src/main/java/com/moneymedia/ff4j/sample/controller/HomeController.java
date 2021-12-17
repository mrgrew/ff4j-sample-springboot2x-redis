package com.moneymedia.ff4j.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String home() {
        return "redirect:/ff4j-web-console";
    }
}
