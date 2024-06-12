package com.example.sl.controller;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.domain.service.BookService;
import com.example.sl.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/book")
public class BookController {

    @GetMapping("/book_start")
    public void books(){

    }
    @GetMapping("/book1")
    public void book1(){

    }
    @GetMapping("/book2")
    public void book2(){

    }
    @GetMapping("/book_finish")
    public void bookf(){

    }

    @Autowired
    private BookService bookService;

    // 예매 생성 API
    @PostMapping("/make")
    public ResponseEntity<BookEntity> makeBook(@RequestBody BookDto bookDto) {
        BookEntity bookEntity = bookService.makeReservation(bookDto);
        return ResponseEntity.ok(bookEntity);
    }

    // 예매 취소 API
    @PostMapping("/cancel/{id}")
    public ResponseEntity<BookEntity> cancelBook(@PathVariable("id") String id) {
        BookEntity bookEntity = bookService.cancelReservation(id);
        return ResponseEntity.ok(bookEntity);
    }
}
