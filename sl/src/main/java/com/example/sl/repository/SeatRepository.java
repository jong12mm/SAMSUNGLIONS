package com.example.sl.repository;

import com.example.sl.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
    List<SeatEntity> findByZoneAndReservedFalse(String zone);

    @Query("SELECT DISTINCT s.zone FROM SeatEntity s")
    List<String> findDistinctZones();

    @Query("SELECT DISTINCT s.zone FROM SeatEntity s WHERE s.mainZone = :mainZone")
    List<String> findDistinctZonesByMainZone(@Param("mainZone") String mainZone);

    @Query("SELECT s FROM SeatEntity s WHERE s.mainZone = :mainZone AND s.zone = :zone AND s.reserved = false")
    List<SeatEntity> findByMainZoneAndZoneAndReservedFalse(@Param("mainZone") String mainZone, @Param("zone") String zone);


}
