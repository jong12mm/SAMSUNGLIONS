package com.example.sl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/samsung")
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
//            model.addAttribute("userDetails",userDetails);
        }
        return "samsung";
    }

//    @GetMapping("/navbar")
//    public String navbar() {
//        log.info("GET /");
//        return "navbar";
//    }
//    @GetMapping("/footer")
//    public String footer() {
//        log.info("GET /");
//        return "footer";
//    }
}