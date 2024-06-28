package com.example.sl.controller;

import com.example.sl.domain.service.StoryService;

import com.example.sl.entity.StoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fan")
public class FanController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/fan_cheerdetails")
    public String fancm(){
        return "fan/fan_cheerdetails";
    }
    @GetMapping("/fan_cheermain")
    public String fancd(){
        return "fan/fan_cheermain";
    }
    @GetMapping("/fan_faq")
    public String fanfq(){
        return "fan/fan_faq";
    }
    @GetMapping("/fan_free")
    public String fanf(){
        return "fan/fan_free";
    }
    @GetMapping("/fan_main")
    public String fanm(){
        return "fan/fan_main";
    }
    @GetMapping("/fan_story")
    public String fStory() {
        return "fan/fan_story";
    }

    @GetMapping("/fan_gallery_user")
    public String fan_gallery_user() {
        return "fan/fan_gallery_user";
    }


}
