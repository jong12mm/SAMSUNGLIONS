package com.example.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @GetMapping("/KimSangheon")
    public String KimSangheon() {
        return "detail/KimSangheon";
    }

    @GetMapping("/LeeSujin")
    public String LeeSujin() {
        return "detail/LeeSujin";
    }

    @GetMapping("/KimHayeon")
    public String KimHayeon() {
        return "detail/KimHayeon";
    }

    @GetMapping("/JeongYumi")
    public String JeongYumi() {
        return "detail/JeongYumi";
    }

    @GetMapping("/KimGahyun")
    public String KimGahyun() {
        return "detail/KimGahyun";
    }

    @GetMapping("/LeeSohyeon")
    public String LeeSohyeon() {
        return "detail/LeeSohyeon";
    }

    @GetMapping("/KimMiso")
    public String KimMiso() {
        return "detail/KimMiso";
    }

    @GetMapping("/KwonGayoung")
    public String KwonGayoung() {
        return "detail/KwonGayoung";
    }

    @GetMapping("/KimYujung")
    public String KimYujung() {
        return "detail/KimYujung";
    }

    @GetMapping("/SungHyoryun")
    public String SungHyoryun() {
        return "detail/SungHyoryun";
    }

    @GetMapping("/SongYeeun")
    public String SongYeeun() {
        return "detail/SongYeeun";
    }

    @GetMapping("/ChaHyomin")
    public String ChaHyomin() {
        return "detail/ChaHyomin";
    }







}
