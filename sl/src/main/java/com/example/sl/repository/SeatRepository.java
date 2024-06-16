package com.example.sl.repository;

import com.example.sl.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
    List<SeatEntity> findByReservedFalse(); // 가용한 좌석 조회 메서드
    java.util.Optional<SeatEntity> findBySeatNumber(String seatNumber);
}
