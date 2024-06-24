package com.example.sl.domain.service;

import com.example.sl.domain.dto.GameInfoDto;
import com.example.sl.entity.GameInfoEntity;
import com.example.sl.repository.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameInfoServiceImpl implements GameInfoService {

    private final GameInfoRepository gameInfoRepository;

    @Autowired
    public GameInfoServiceImpl(GameInfoRepository gameInfoRepository) {
        this.gameInfoRepository = gameInfoRepository;
    }

    @Override
    public List<GameInfoDto> getAllGameInfo() {
        List<GameInfoEntity> gameInfoEntities = gameInfoRepository.findAll();
        return gameInfoEntities.stream()
                .map(entity -> new GameInfoDto(
                        entity.getGameInfoId(),
                        entity.getGameName(),
                        entity.getStadium(),
                        entity.getStartTime()
                ))
                .collect(Collectors.toList());
    }
}
