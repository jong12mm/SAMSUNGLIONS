package com.example.sl.repository;

import com.example.sl.entity.GameInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameInfoRepository extends JpaRepository<GameInfoEntity, Long> {
}