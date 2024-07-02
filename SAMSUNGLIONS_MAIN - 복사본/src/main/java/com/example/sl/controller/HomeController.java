package com.example.sl.controller;

import com.example.sl.domain.dto.ClubNewsDTO;
import com.example.sl.domain.dto.FanBoardDTO;
import com.example.sl.domain.dto.FaqBoardDTO;
import com.example.sl.domain.service.ClubNewsService;
import com.example.sl.domain.service.FanBoardService;
import com.example.sl.domain.service.FaqBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private FanBoardService boardService;

    @Autowired
    private ClubNewsService clubNewsService;
    @Autowired
    private FaqBoardService faqBoardService;

    @GetMapping("/samsung")
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<FanBoardDTO> boardList = boardService.findAll();
        List<ClubNewsDTO> boardList2 = clubNewsService.findAll();
        List<FaqBoardDTO> boardList3 = faqBoardService.findAll();
        model.addAttribute("boardList", boardList);
        model.addAttribute("boardList2", boardList2);
        model.addAttribute("boardList3", boardList3);

        List<FanBoardDTO> latestFanBoard = boardList.stream()
                .sorted(Comparator.comparing(FanBoardDTO::getBoardCreatedTime).reversed())
                .limit(3)
                .collect(Collectors.toList());

        List<ClubNewsDTO> latestClubNews = boardList2.stream()
                .sorted(Comparator.comparing(ClubNewsDTO::getBoardCreatedTime).reversed())
                .limit(7)
                .collect(Collectors.toList());


        model.addAttribute("latestFanBoard", latestFanBoard);
        model.addAttribute("latestClubNews", latestClubNews);


        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
//            model.addAttribute("userDetails",userDetails);
        }



        System.out.println("USERDETAILS : " + userDetails);
        return "samsung";
    }
}