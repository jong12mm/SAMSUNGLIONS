package com.example.sl.controller;

import com.example.sl.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {


//    private final UserService userService;



//    @GetMapping("/login")
//    public ResponseEntity<String> login(){
//        return ResponseEntity.ok().body(userService.login("",""));
//
//    }
}
