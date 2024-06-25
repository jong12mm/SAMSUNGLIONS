package com.example.sl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/samsung")
    public String samsung() {
        log.info("GET /");
        return "samsung";
    }

    @GetMapping("/navbar")
    public String navbar() {
        log.info("GET /");
        return "navbar";
    }
    @GetMapping("/footer")
    public String footer() {
        log.info("GET /");
        return "footer";
    }
}