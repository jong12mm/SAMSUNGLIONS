package com.example.sl.repository;

import com.example.sl.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
    List<SeatEntity> findByZoneAndReservedFalse(String zone);

    @Query("SELECT DISTINCT s.zone FROM SeatEntity s")
    List<String> findDistinctZones();
}
