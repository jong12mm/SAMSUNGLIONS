package com.example.sl.domain.service;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.entity.BookEntity;
import com.example.sl.entity.GameInfoEntity;
import com.example.sl.repository.BookRepository;
import com.example.sl.repository.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GameInfoRepository gameInfoRepository;

    @Override
    public BookEntity makeReservation(BookDto bookDto) {
        // BookDto에서 필요한 정보를 추출하여 BookEntity 객체 생성
        BookEntity bookEntity = new BookEntity();
        bookEntity.setSeat(bookDto.getSeat());
        bookEntity.setName(bookDto.getName());
        // BookDto에 추가된 gameInfoId를 사용하여 실제 GameInfo 객체를 조회하고 연결
        GameInfoEntity gameInfoEntity = gameInfoRepository.findById(Long.valueOf(bookDto.getGameInfoId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid gameInfoId"));
        bookEntity.setGameinfo(String.valueOf(gameInfoEntity));
        bookEntity.setDate(LocalDateTime.now());
        bookEntity.setBookstatus("예약됨");

        // 예약 정보 저장
        return bookRepository.save(bookEntity);


    }

    @Override
    public BookEntity cancelReservation(String bookid) {
        // reservationId를 사용하여 예약 정보를 조회
        BookEntity bookEntity = bookRepository.findById(Long.valueOf(bookid))
                .orElseThrow(() -> new IllegalArgumentException("Invalid bookid"));

        // 예약 상태를 "취소됨"으로 변경
        bookEntity.setBookstatus("취소됨");

        // 변경된 예약 정보 저장
        bookRepository.save(bookEntity);

        return bookEntity;

    }
}