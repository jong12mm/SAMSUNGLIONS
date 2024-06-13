package com.example.sl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.entity.BookEntity;
import com.example.sl.domain.service.BookService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/book")
public class BookController {


    private final BookService bookService;


    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book1")
    public void book1() {
    }

    @GetMapping("/book2")
    public void book2() {
    }

    @GetMapping("/book_finish")
    public void bookf() {
    }

    @GetMapping("/book_start")
    public String showBookingPage() {
        return "book_start";
    }

    @PostMapping("/make")
    @ResponseBody
    public ResponseEntity<?> makeBook(@RequestBody BookDto bookDto) {
        log.info("Received booking request: {}", bookDto);
        try {
            BookEntity bookEntity = bookService.makeBook(bookDto);
            return ResponseEntity.ok(bookEntity);
        } catch (IllegalArgumentException e) {
            log.error("Invalid gameInfoId provided: {}", bookDto.getGameinfoId(), e);
            return ResponseEntity.badRequest().body("Invalid gameInfoId provided: " + bookDto.getGameinfoId());
        } catch (Exception e) {
            log.error("예약 생성 중 오류 발생: ", e);
            return ResponseEntity.status(500).body("예약 생성 중 오류 발생: " + e.getMessage());
        }
    }


    @PostMapping("/cancel/{id}")
    @ResponseBody // JSON 응답을 위해 필요
    public ResponseEntity<?> cancelBook(@PathVariable("id") String id) {
        try {
            BookEntity bookEntity = bookService.cancelBook(id);
            return ResponseEntity.ok(bookEntity);
        } catch (Exception e) {
            log.error("예약 취소 중 오류 발생: ", e);
            return ResponseEntity.status(500).body("예약 취소 중 오류 발생: " + e.getMessage());
        }
    }
    // 모든 예약 정보 조회 API
    @GetMapping("/list")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        try {
            List<BookEntity> bookList = bookService.getAllBooks();
            return ResponseEntity.ok(bookList);
        } catch (Exception e) {
            log.error("예약 정보 조회 중 오류 발생: ", e);
            return ResponseEntity.status(500).body(null);
        }
    }
}
