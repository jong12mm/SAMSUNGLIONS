package com.example.sl.domain.service;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.domain.dto.SeatDto;
import com.example.sl.entity.BookEntity;

import java.util.List;

public interface BookService {
    BookEntity makeBook(BookDto bookDto);
    BookEntity cancelBook(String bookid);
    List<BookEntity> getAllBooks();
    List<String> getZones(); // 모든 구역을 가져오는 메서드
    List<SeatDto> getAvailableSeatsByZone(String zone); // 특정 구역의 가용한 좌석 조회
}
