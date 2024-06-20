package com.example.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @GetMapping("/player_main")
    public void pmain() {

    }
    @GetMapping("/staff")
    public void pstaff() {

    }
    @GetMapping("/pitcher")
    public void ppitcher() {

    }
    @GetMapping("/hitter")
    public void phitter() {

    }
    @GetMapping("/army")
    public void parmy() {

    }
    @GetMapping("/newplayer")
    public void pnewplayer() {

    }
}
