package com.example.sl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/book")
public class BookController {

    @GetMapping("/book_start")
    public void books(){

    }
    @GetMapping("/book1")
    public void book1(){

    }
    @GetMapping("/book2")
    public void book2(){

    }
    @GetMapping("/book_finish")
    public void bookf(){

    }
}
