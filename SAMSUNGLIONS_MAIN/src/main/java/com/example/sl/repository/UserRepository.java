package com.example.sl.repository;

import com.example.sl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByRealnameAndBirthAndEmail(String realname, LocalDate birth, String email);

    Optional<User> findByUserNameAndEmail(String userName, String email);
}
