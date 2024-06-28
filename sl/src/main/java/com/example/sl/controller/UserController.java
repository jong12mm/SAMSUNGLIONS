package com.example.sl.controller;

import com.example.sl.domain.dto.UserAdultJoinRequest;
import com.example.sl.domain.dto.UserChildJoinRequest;
import com.example.sl.domain.service.UserService;
import com.example.sl.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private int a;

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

    @GetMapping("/profile")
    public String showUserProfile(Authentication authentication, Model model) {
        String userName = authentication.getName();
        User user = userService.getUserInfo(userName);
        model.addAttribute("user", user);
        return "profile";
    }

    // 아이디 찾기 페이지를 반환하는 메서드
    @GetMapping("/find_username")
    public String showFindUsernamePage() {
        return "find_username";
    }

    // 아이디 찾기 요청을 처리하는 메서드
    @PostMapping("/find_username")
    public String findUsername(@RequestParam("realname") String realname,
                               @RequestParam("birth") String birth,
                               @RequestParam("email") String email,
                               Model model) {
        try {
            LocalDate birthDate = LocalDate.parse(birth); // 입력된 생년월일을 LocalDate로 변환
            String username = userService.findUsername(realname, birthDate, email);

            if (username != null) {
                model.addAttribute("message", "Your username is: " + username);
            } else {
                model.addAttribute("errorMessage", "회원정보가 일치하지 않습니다. ");
            }
        } catch (DateTimeParseException e) {
            model.addAttribute("errorMessage", "생년월일 입력방식이 잘못되었습니다. YYYY-MM-DD.");
        }
        return "find_username_result";
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
