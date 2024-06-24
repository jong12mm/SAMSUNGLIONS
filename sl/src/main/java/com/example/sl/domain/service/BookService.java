package com.example.sl.domain.service;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.entity.BookEntity;
import com.example.sl.entity.SeatEntity;

import java.util.List;

public interface BookService {
    BookEntity makeBook(BookDto bookDto);
    BookEntity cancelBook(String bookid);
    List<BookEntity> getAllBooks();
    List<String> getZones();
    List<String> getZonesByMainZone(String mainZone);
    List<SeatEntity> getAvailableSeatsByZone(String zone);
    List<SeatEntity> getAvailableSeatsByMainZoneAndZone(String mainZone, String zone); // 새로운 메서드
}
