package com.example.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fan")
public class FanController {
    @GetMapping("/fan_cheerdetails")
    public void fancm(){

    }
    @GetMapping("/fan_cheermain")
    public void fancd(){

    }
    @GetMapping("/fan_faq")
    public void fanfq(){

    }
    @GetMapping("/fan_free")
    public void fanf(){

    }
//    @GetMapping("/fan_gallery")
//    public void fang(){
//
//    }
    @GetMapping("/fan_main")
    public void fanm(){

    }
    @GetMapping("/fan_story")
    public void fans(){

    }
}
