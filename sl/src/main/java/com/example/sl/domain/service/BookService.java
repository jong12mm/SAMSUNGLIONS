package com.example.sl.domain.service;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.domain.dto.PaymentDto;
import com.example.sl.entity.BookEntity;
import com.example.sl.entity.PaymentEntity;
import com.example.sl.entity.SeatEntity;
import com.siot.IamportRestClient.exception.IamportResponseException;

import java.io.IOException;
import java.util.List;

public interface BookService {
    BookEntity makeBook(BookDto bookDto);
    BookEntity cancelBook(String bookId) throws IOException, IamportResponseException;
    List<BookEntity> getAllBooks();
    List<String> getZones();
    List<SeatEntity> getAvailableSeatsByMainZoneAndZone(String mainZone, String zone); // 새로운 메서드
    List<String> getZonesByMainZone(String mainZone);

    List<SeatEntity> getAvailableSeatsByZone(String zone);
    PaymentEntity savePayment(PaymentDto paymentDto);
    BookEntity updateImpUid(Long bookId, String impUid);
    void deleteById(Long id);
}
