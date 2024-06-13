package com.example.sl.domain.service;

import com.example.sl.domain.dto.BookDto;
import com.example.sl.entity.BookEntity;

import java.util.List;

public interface BookService {
    BookEntity makeBook(BookDto bookDto);
    BookEntity cancelBook(String bookid);
    List<BookEntity> getAllBooks();
}
