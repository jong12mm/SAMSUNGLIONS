package com.example.sl.controller;

import com.example.sl.domain.dto.ClubNewsDTO;
import com.example.sl.domain.dto.FanBoardDTO;
import com.example.sl.domain.service.BoardService;
import com.example.sl.domain.service.ClubNewsService;
import com.example.sl.domain.service.FanBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private FanBoardService boardService;

    @Autowired
    private ClubNewsService clubNewsService;

    @GetMapping("/samsung")
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<FanBoardDTO> boardList = boardService.findAll();
        List<ClubNewsDTO> boardList2 = clubNewsService.findAll();
        model.addAttribute("boardList", boardList);
        model.addAttribute("boardList2", boardList2);

        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
//            model.addAttribute("userDetails",userDetails);
        }

        System.out.println("USERDETAILS : " + userDetails);
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