package com.example.sl.controller;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.domain.dto.PaymentDto;
import com.example.sl.domain.dto.SeatDto;
import com.example.sl.domain.service.BookService;
import com.example.sl.domain.service.PaymentService;
import com.example.sl.entity.BookEntity;
import com.example.sl.entity.PaymentEntity;
import com.example.sl.entity.SeatEntity;
import com.siot.IamportRestClient.exception.IamportResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final PaymentService paymentService;

    @Autowired
    public BookController(BookService bookService, PaymentService paymentService) {
        this.bookService = bookService;
        this.paymentService = paymentService;
    }

    @GetMapping("/book_start")
    public String showBookingPage(Model model) {
        List<String> zones = bookService.getZones();
        model.addAttribute("zones", zones);
        return "book_start";
    }

    @GetMapping("/zones/{mainZone}")
    @ResponseBody
    public List<String> getZonesByMainZone(@PathVariable("mainZone") String mainZone) {
        log.info("Fetching zones for mainZone: {}", mainZone);
        return bookService.getZonesByMainZone(mainZone);
    }

    @GetMapping("/seats/{mainZone}/{zone}")
    @ResponseBody
    public List<SeatEntity> getSeatsByMainZoneAndZone(@PathVariable("mainZone") String mainZone, @PathVariable("zone") String zone) {
        log.info("Fetching seats for mainZone: {} and zone: {}", mainZone, zone);
        return bookService.getAvailableSeatsByMainZoneAndZone(mainZone, zone);
    }



    @PostMapping("/make")
    @ResponseBody
    public ResponseEntity<?> makeBook(@RequestBody BookDto bookDto) {
        log.info("Received booking request: {}", bookDto);
        try {
            if (bookDto.getSeatid() == null) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", "seatid must not be null"));
            }
            BookEntity bookEntity = bookService.makeBook(bookDto);
            return ResponseEntity.ok(Collections.singletonMap("bookId", bookEntity.getBookid()));
        } catch (IllegalArgumentException e) {
            log.error("Invalid gameinfoId provided: {}", bookDto.getGameinfoId(), e);
            return ResponseEntity.badRequest().body(Collections.singletonMap("success", false));
        } catch (Exception e) {
            log.error("예약 생성 중 오류 발생: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("success", false));
        }
    }

    @PostMapping("/cancel")
    @ResponseBody
    public ResponseEntity<?> cancelBook(@RequestBody List<Long> ids) {
        try {
            for (Long id : ids) {
                BookEntity cancelledBook = bookService.cancelBook(id.toString());
                PaymentDto paymentDto = new PaymentDto();
                paymentDto.setCancelRequestAmount(cancelledBook.getPrice());
                paymentService.cancelPayment(cancelledBook.getImpUid(), paymentDto);
                bookService.deleteById(id); // 예매 취소 후 데이터베이스에서 삭제
            }
            return ResponseEntity.ok(Collections.singletonMap("success", true));
        } catch (IllegalArgumentException e) {
            log.error("Invalid bookId provided: {}", ids, e);
            return ResponseEntity.badRequest().body(Collections.singletonMap("success", false));
        } catch (RuntimeException e) {
            log.error("예약 취소 중 오류 발생: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예약 취소 중 오류 발생: " + e.getMessage());
        } catch (IOException | IamportResponseException e) {
            if (e.getMessage().contains("이미 전액취소된 주문입니다.")) {
                log.warn("이미 전액취소된 주문입니다.");
                return ResponseEntity.ok(Collections.singletonMap("success", true));
            }
            log.error("결제 취소 중 오류 발생: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("결제 취소 중 오류 발생: " + e.getMessage());
        }
    }

    @PostMapping("/payment/save")
    @ResponseBody
    public ResponseEntity<?> savePayment(@RequestBody PaymentDto paymentDto) {
        log.info("Saving payment: {}", paymentDto);
        try {
            PaymentEntity paymentEntity = bookService.savePayment(paymentDto);
            return ResponseEntity.ok(Collections.singletonMap("paymentStatus", "성공"));
        } catch (IllegalArgumentException e) {
            log.error("Invalid bookId provided: {}", paymentDto.getBookId(), e);
            return ResponseEntity.badRequest().body(Collections.singletonMap("paymentStatus", "실패"));
        } catch (Exception e) {
            log.error("결제 저장 중 오류 발생: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("paymentStatus", "실패"));
        }
    }

    @PostMapping("/update-impUid")
    @ResponseBody
    public ResponseEntity<?> updateImpUid(@RequestBody Map<String, String> request) {
        try {
            Long bookId = Long.parseLong(request.get("bookId"));
            String impUid = request.get("impUid");

            bookService.updateImpUid(bookId, impUid);

            return ResponseEntity.ok(Collections.singletonMap("success", true));
        } catch (Exception e) {
            log.error("ImpUid 업데이트 중 오류 발생: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("success", false));
        }
    }

    @GetMapping("/list")
    public String getAllBooks(Model model) {
        List<BookEntity> bookList = bookService.getAllBooks();
        model.addAttribute("bookList", bookList);
        return "booklist";
    }

    @PostMapping("/payment/cancel")
    @ResponseBody
    public ResponseEntity<?> cancelPayment(@RequestBody PaymentDto paymentDto) {
        log.info("Received payment cancellation request: {}", paymentDto);
        try {
            paymentService.cancelPayment(paymentDto.getImpUid(), paymentDto);
            return ResponseEntity.ok(Collections.singletonMap("success", true));
        } catch (IllegalArgumentException e) {
            log.error("Invalid payment details provided: {}", paymentDto, e);
            return ResponseEntity.badRequest().body(Collections.singletonMap("success", false));
        } catch (IOException | IamportResponseException e) {
            log.error("결제 취소 중 오류 발생: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("결제 취소 중 오류 발생: " + e.getMessage());
        }
    }
}
