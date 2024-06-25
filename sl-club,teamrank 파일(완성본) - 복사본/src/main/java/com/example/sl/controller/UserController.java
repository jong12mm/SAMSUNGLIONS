package com.example.sl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @GetMapping("/join_start")
    public void joins () {

    }

    @GetMapping("/join_finish")
    public void joinf () {

    }

    @GetMapping("/adult_join")
    public void ajoin () {

    }

    @GetMapping("/children_join")
    public void cjoin () {

    }
}
