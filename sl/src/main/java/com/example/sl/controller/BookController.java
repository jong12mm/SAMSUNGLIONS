package com.example.sl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.entity.BookEntity;
import com.example.sl.domain.service.BookService;

@Controller
@Slf4j
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book_start")
    public void books() {
        // 시작 페이지와 관련된 작업을 처리
    }

    @GetMapping("/book1")
    public void book1() {
        // 첫 번째 책과 관련된 작업을 처리
    }

    @GetMapping("/book2")
    public void book2() {
        // 두 번째 책과 관련된 작업을 처리
    }

    @GetMapping("/book_finish")
    public void bookf() {
        // 마무리 페이지와 관련된 작업을 처리
    }

    // 예약 생성 API
    @PostMapping("/make")
    public ResponseEntity<BookEntity> makeBook(@RequestBody BookDto bookDto) {
        try {
            BookEntity bookEntity = bookService.makeBook(bookDto);
            return ResponseEntity.ok(bookEntity);
        } catch (Exception e) {
            log.error("예약 생성 중 오류 발생: ", e);
            return ResponseEntity.status(500).body(null);
        }
    }

    // 예약 취소 API
    @PostMapping("/cancel/{id}")
    public ResponseEntity<BookEntity> cancelBook(@PathVariable("id") String id) {
        try {
            BookEntity bookEntity = bookService.cancelBook(id);
            return ResponseEntity.ok(bookEntity);
        } catch (Exception e) {
            log.error("예약 취소 중 오류 발생: ", e);
            return ResponseEntity.status(500).body(null);
        }
    }
}
