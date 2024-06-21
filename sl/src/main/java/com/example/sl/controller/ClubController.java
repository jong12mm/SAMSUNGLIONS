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
    public String announcement(){
        return "club/announcement";
    }
    @GetMapping("/lionsPark")
    public String lionsPark(){
        return "club/lionsPark";
    }
    @GetMapping("/slhistory")
    public String slhistory(){
        return "club/slhistory";
    }
    @GetMapping("/slintro")
    public String slintro(){
        return "club/slintro";
    }
    @GetMapping("/slnews")
    public String slnews(){
        return "club/slnews";
    }
}
