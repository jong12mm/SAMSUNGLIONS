package com.example.sl.repository;

import com.example.sl.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByBookstatus(String bookstatus);
}
