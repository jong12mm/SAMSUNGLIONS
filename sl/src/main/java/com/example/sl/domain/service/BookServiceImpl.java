package com.example.sl.domain.service;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.domain.dto.PaymentDto;
import com.example.sl.entity.BookEntity;
import com.example.sl.entity.PaymentEntity;
import com.example.sl.entity.SeatEntity;
import com.example.sl.repository.BookRepository;
import com.example.sl.repository.PaymentRepository;
import com.example.sl.repository.SeatRepository;
import com.siot.IamportRestClient.exception.IamportResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @Override
    public BookEntity makeBook(BookDto bookDto) {
        if (bookDto.getSeatid() == null) {
            throw new IllegalArgumentException("seatid must not be null");
        }

        Optional<SeatEntity> seatEntityOptional = seatRepository.findById(bookDto.getSeatid());
        if (!seatEntityOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid seatId");
        }
        SeatEntity seatEntity = seatEntityOptional.get();

        BookEntity bookEntity = new BookEntity();
        bookEntity.setSeatid(bookDto.getSeatid());
        bookEntity.setSeat(bookDto.getSeat());
        bookEntity.setName(bookDto.getName());
        bookEntity.setGameinfo(bookDto.getGameinfoId());
        bookEntity.setDate(LocalDateTime.now());
        bookEntity.setBookstatus("PENDING"); // 예약 상태를 "PENDING"으로 설정
        bookEntity.setPayid(bookDto.getPayid());
        bookEntity.setPrice(seatEntity.getPrice());
        bookEntity.setMainZone(bookDto.getMainZone());
        bookEntity.setZone(bookDto.getZone());
        bookEntity.setImpUid(bookDto.getImpUid());

        return bookRepository.save(bookEntity);
    }

    @Override
    public void confirmBook(Long bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid bookId"));

        bookEntity.setBookstatus("BOOKED");

        Optional<SeatEntity> seatEntityOptional = seatRepository.findById(bookEntity.getSeatid());
        if (seatEntityOptional.isPresent()) {
            SeatEntity seatEntity = seatEntityOptional.get();
            seatEntity.setReserved(true);
            seatRepository.save(seatEntity);
        }

        bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity cancelBook(String bookId) throws IOException, IamportResponseException {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(Long.parseLong(bookId));
        if (!bookEntityOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid bookId");
        }

        BookEntity bookEntity = bookEntityOptional.get();
        bookEntity.setBookstatus("CANCELLED");

        Optional<SeatEntity> seatEntityOptional = seatRepository.findById(bookEntity.getSeatid());
        if (seatEntityOptional.isPresent()) {
            SeatEntity seatEntity = seatEntityOptional.get();
            seatEntity.setReserved(false);
            seatRepository.save(seatEntity);
        }

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setCancelRequestAmount(bookEntity.getPrice());
        paymentService.cancelPayment(bookEntity.getImpUid(), paymentDto);

        return bookRepository.save(bookEntity);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<String> getZones() {
        return seatRepository.findAll()
                .stream()
                .map(SeatEntity::getZone)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<SeatEntity> getAvailableSeatsByZone(String zone) {
        return seatRepository.findByZoneAndReservedFalse(zone);
    }

    @Override
    public List<SeatEntity> getAvailableSeatsByMainZoneAndZone(String mainZone, String zone) {
        return seatRepository.findByMainZoneAndZoneAndReservedFalse(mainZone, zone);
    }

    @Override
    public List<String> getZonesByMainZone(String mainZone) {
        return seatRepository.findDistinctZonesByMainZone(mainZone);
    }

    @Override
    public PaymentEntity savePayment(PaymentDto paymentDto) {
        BookEntity bookEntity = bookRepository.findById(paymentDto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid bookId"));

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setAmount(paymentDto.getAmount());
        paymentEntity.setPaymentDateTime(paymentDto.getPaymentDateTime());
        paymentEntity.setPaymentMethod(paymentDto.getPaymentMethod());
        paymentEntity.setPaymentStatus(paymentDto.getPaymentStatus());
        paymentEntity.setImpUid(paymentDto.getImpUid());
        paymentEntity.setMerchantUid(paymentDto.getMerchantUid());
        paymentEntity.setBookEntity(bookEntity);

        return paymentRepository.save(paymentEntity);
    }

    @Override
    public BookEntity updateImpUid(Long bookId, String impUid) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(bookId);
        if (!bookEntityOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid bookId");
        }

        BookEntity bookEntity = bookEntityOptional.get();
        bookEntity.setImpUid(impUid);

        return bookRepository.save(bookEntity);
    }

    @Override
    public void checkPendingReservations() {
        List<BookEntity> pendingBooks = bookRepository.findByBookstatus("PENDING");
        for (BookEntity book : pendingBooks) {
            book.setBookstatus("CANCELLED");
            Optional<SeatEntity> seatEntityOptional = seatRepository.findById(book.getSeatid());
            if (seatEntityOptional.isPresent()) {
                SeatEntity seatEntity = seatEntityOptional.get();
                seatEntity.setReserved(false);
                seatRepository.save(seatEntity);
            }
            bookRepository.save(book);
        }
    }

    @Override
    public void cancelPendingReservation(Long bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid bookId"));

        bookEntity.setBookstatus("CANCELLED");
        Optional<SeatEntity> seatEntityOptional = seatRepository.findById(bookEntity.getSeatid());
        if (seatEntityOptional.isPresent()) {
            SeatEntity seatEntity = seatEntityOptional.get();
            seatEntity.setReserved(false);
            seatRepository.save(seatEntity);
        }
        bookRepository.save(bookEntity);
    }
}
