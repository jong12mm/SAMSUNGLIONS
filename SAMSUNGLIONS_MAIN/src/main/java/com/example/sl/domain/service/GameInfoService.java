package com.example.sl.domain.service;

import com.example.sl.entity.GameInfoEntity;
import com.example.sl.repository.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameInfoService {

    @Autowired
    private GameInfoRepository gameInfoRepository;

    public List<GameInfoEntity> getAllGameInfo() {
        return gameInfoRepository.findAll();
    }
}
