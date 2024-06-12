package com.example.sl.domain.service;


import com.example.sl.domain.dto.BookDto;
import com.example.sl.entity.BookEntity;

public interface BookService {
    BookEntity makeReservation(BookDto bookDto);
    BookEntity cancelReservation(String bookid);


}
