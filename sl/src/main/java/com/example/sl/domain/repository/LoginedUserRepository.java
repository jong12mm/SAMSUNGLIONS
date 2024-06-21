package com.example.sl.domain.repository;

import com.example.sl.entity.LoginedUser;
import com.example.sl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginedUserRepository extends JpaRepository<LoginedUser,Long> {
    Optional<LoginedUser> findByUserName(String userName);
}
