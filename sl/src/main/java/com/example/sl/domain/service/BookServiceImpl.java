package com.example.sl.domain.service;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.domain.service.BookService;
import com.example.sl.entity.BookEntity;
import com.example.sl.entity.GameInfoEntity;
import com.example.sl.repository.BookRepository;
import com.example.sl.repository.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final GameInfoRepository gameInfoRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, GameInfoRepository gameInfoRepository) {
        this.bookRepository = bookRepository;
        this.gameInfoRepository = gameInfoRepository;
    }

    @Override
    public BookEntity makeBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setSeat(bookDto.getSeat());
        bookEntity.setName(bookDto.getName());

        GameInfoEntity gameInfoEntity = gameInfoRepository.findById(Long.valueOf(bookDto.getGameInfoId()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid gameInfoId"));
        bookEntity.setGameinfo(gameInfoEntity.getGameName()); // 필요한 필드를 사용하여 설정
        bookEntity.setDate(LocalDateTime.now());
        bookEntity.setBookstatus("예약됨");

        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity cancelBook(String bookid) {
        BookEntity bookEntity = bookRepository.findById(Long.valueOf(bookid))
                .orElseThrow(() -> new IllegalArgumentException("Invalid bookid"));

        bookEntity.setBookstatus("취소됨");

        return bookRepository.save(bookEntity);
    }
}
