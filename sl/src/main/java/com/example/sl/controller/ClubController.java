package com.example.sl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/club")
public class ClubController {

    @GetMapping("/announcement")
    public void announcement(){

    }
    @GetMapping("/lionsPark")
    public void lionsPark(){

    }
    @GetMapping("/slhistory")
    public void slhistory(){

    }
    @GetMapping("/slintro")
    public void slintro(){

    }
    @GetMapping("/slnews")
    public void slnews(){

    }
}
