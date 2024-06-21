package com.example.sl.controller;

import com.example.sl.domain.dto.LoginRequest;
import com.example.sl.domain.dto.UserAdultJoinRequest;
import com.example.sl.domain.dto.UserChildJoinRequest;
import com.example.sl.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j

@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/join_start")
    public void t4() {
        log.info("join start");
    }

    @GetMapping("/join_finish")
    public void t5() {
        log.info("join finish");
    }






    @PostMapping("/adult_join")
    public String handleUserJoinRequest(@ModelAttribute UserAdultJoinRequest requestDto) {
        // 사용자 등록 처리 로직 호출
        boolean result = userService.userAdultJoin(requestDto);

        if(result) {
            return "redirect:/user/join_finish";
        }
        else {
            return "redirect:/user/adult_join";
        }
    }




    @GetMapping("/adult_join")
    public void t1(){
        log.info("어른회원가입");
    }
    @GetMapping("/children_join")
    public void t2() {
        log.info("애들가입");
    }
    @GetMapping("/login")
    public void t3() {
        log.info("로그인");
    }




    @PostMapping("/children_join")
    public String handleUserJoinRequest(@ModelAttribute UserChildJoinRequest requestDto) {
        // 사용자 등록 처리 로직 호출
        boolean result = userService.userChildJoin(requestDto);

        if(result) {
            return "redirect:/user/join_finish";
        }
        else {
            return "redirect:/user/child_join";
        }
    }


//    @PostMapping("/login")
//    public String login(@ModelAttribute LoginRequest dto) {
//        String token = userService.login(dto.getUserName(),dto.getPassword());
//
//        if(token!=null){
//            return "redirect:/samsung";
//        }
//        else{
//            return "redirect:/user/login";
//        }
//
//    }

}
