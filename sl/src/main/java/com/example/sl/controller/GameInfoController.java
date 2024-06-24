package com.example.sl.controller;

import com.example.sl.domain.dto.GameInfoDto;
import com.example.sl.domain.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameInfoController {

    private final GameInfoService gameInfoService;

    @Autowired
    public GameInfoController(GameInfoService gameInfoService) {
        this.gameInfoService = gameInfoService;
    }

    @GetMapping("/book/game-info")
    public String getGameInfoList(Model model) {
        List<GameInfoDto> gameInfoList = gameInfoService.getAllGameInfo();
        model.addAttribute("gameInfoList", gameInfoList);
        return "book/book_game_info";
    }
}
