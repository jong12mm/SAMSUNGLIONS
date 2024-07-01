package com.example.sl.controller;

import com.example.sl.domain.service.GameInfoService;
import com.example.sl.entity.GameInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameInfoController {

    @Autowired
    private GameInfoService gameInfoService;

    @GetMapping("/book")
    public String getGameInfo(Model model) {
        List<GameInfoEntity> gameInfoList = gameInfoService.getAllGameInfo();
        model.addAttribute("gameInfoList", gameInfoList);
        return "book_start";
    }
}
