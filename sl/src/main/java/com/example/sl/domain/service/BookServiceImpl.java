package com.example.sl.domain.service;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.entity.BookEntity;
import com.example.sl.entity.GameInfoEntity;
import com.example.sl.entity.SeatEntity;
import com.example.sl.repository.BookRepository;
import com.example.sl.repository.GameInfoRepository;
import com.example.sl.repository.SeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final GameInfoRepository gameInfoRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, GameInfoRepository gameInfoRepository, SeatRepository seatRepository) {
        this.bookRepository = bookRepository;
        this.gameInfoRepository = gameInfoRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public BookEntity makeBook(BookDto bookDto) {
        Long gameInfoId = Long.valueOf(bookDto.getGameinfoId());
        GameInfoEntity gameInfoEntity = gameInfoRepository.findById(gameInfoId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid gameInfoId"));

        BookEntity bookEntity = new BookEntity();
        bookEntity.setSeat(bookDto.getSeat());
        bookEntity.setName(bookDto.getName());
        bookEntity.setGameinfo(gameInfoEntity.getGameName());
        bookEntity.setDate(LocalDateTime.now());
        bookEntity.setBookstatus("예약됨");
        bookEntity.setMainZone(bookDto.getMainZone());  // 메인존 설정
        bookEntity.setZone(bookDto.getZone());          // 존 설정

        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity cancelBook(String bookid) {
        BookEntity bookEntity = bookRepository.findById(Long.valueOf(bookid))
                .orElseThrow(() -> new IllegalArgumentException("Invalid bookid"));
        bookEntity.setBookstatus("취소됨");
        return bookRepository.save(bookEntity);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<String> getZones() {
        return seatRepository.findDistinctZones();
    }

    @Override
    public List<String> getZonesByMainZone(String mainZone) {
        return seatRepository.findDistinctZonesByMainZone(mainZone);
    }

    @Override
    public List<SeatEntity> getAvailableSeatsByZone(String zone) {
        return seatRepository.findByZoneAndReservedFalse(zone);
    }

    @Override
    public List<SeatEntity> getAvailableSeatsByMainZoneAndZone(String mainZone, String zone) {
        return seatRepository.findByMainZoneAndZoneAndReservedFalse(mainZone, zone);
    }
}
