package com.example.sl.controller;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.domain.dto.SeatDto;
import com.example.sl.domain.service.BookService;
import com.example.sl.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/book_start")
    public String showBookingPage(Model model) {
        List<String> zones = bookService.getZones();
        model.addAttribute("zones", zones);
        return "book_start";
    }

    @GetMapping("/seats/{zone}")
    public String getSeatsByZone(@PathVariable("zone") String zone, Model model) {
        log.info("Fetching seats for zone: {}", zone);
        List<SeatDto> availableSeats = bookService.getAvailableSeatsByZone(zone);
        model.addAttribute("availableSeats", availableSeats);
        return "seats_modal :: seatList";
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
    @ResponseBody
    public ResponseEntity<?> cancelBook(@PathVariable("id") String id) {
        try {
            BookEntity bookEntity = bookService.cancelBook(id);
            return ResponseEntity.ok(bookEntity);
        } catch (Exception e) {
            log.error("예약 취소 중 오류 발생: ", e);
            return ResponseEntity.status(500).body("예약 취소 중 오류 발생: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public String getAllBooks(Model model) {
        List<BookEntity> bookList = bookService.getAllBooks();
        model.addAttribute("bookList", bookList);
        return "booklist";
    }
}
