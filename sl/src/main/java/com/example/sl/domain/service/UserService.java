package com.example.sl.domain.service;

import com.example.sl.domain.dto.UserAdultJoinRequest;
import com.example.sl.domain.dto.UserChildJoinRequest;
import com.example.sl.domain.repository.LoginedUserRepository;
import com.example.sl.entity.User;
import com.example.sl.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;





//    public boolean joinadult(UserAdultJoinRequest requestDto) {
//        // 사용자 이름 또는 이메일이 이미 존재하는지 확인
//        if (userRepository.existsByUserName(requestDto.getUserName())) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "사용자 이름이 이미 존재합니다.");
//        }
//        if (userRepository.existsByEmail(requestDto.getEmail())) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "이메일이 이미 존재합니다.");
//        }
//
//
//        // 사용자 등록 로직
//        User user = new User();
//        user.setUserName(requestDto.getUserName());
//        user.setPassword(encoder.encode(requestDto.getPassword()));
//        user.setRealname(requestDto.getRealname());
//        user.setBirth(requestDto.getBirth());
//        user.setChildphone(null);
//        user.setAdultphone(requestDto.getAdultphone());
//        user.setAddr(requestDto.getAddr());
//        user.setEmail(requestDto.getEmail());
//        user.setGender(requestDto.getGender());
//        user.setRole("ROLE_USER");
//        user.setIslocked(false);
//        user.setMembership("일반");
//
//        userRepository.save(user);
//
//        return true;
//    }
//    public boolean joinchild(UserChildJoinRequest requestDto) {
//        // 사용자 이름 또는 이메일이 이미 존재하는지 확인
//        if (userRepository.existsByUserName(requestDto.getUserName())) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "사용자 이름이 이미 존재합니다.");
//        }
//        if (userRepository.existsByEmail(requestDto.getEmail())) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "이메일이 이미 존재합니다.");
//        }
//
//
//        // 사용자 등록 로직
//        User user = new User();
//        user.setUserName(requestDto.getUserName());
//        user.setPassword(encoder.encode(requestDto.getPassword()));
//        user.setRealname(requestDto.getRealname());
//        user.setBirth(requestDto.getBirth());
//        user.setChildphone(requestDto.getChildphone());
//        user.setAdultphone(requestDto.getAdultphone());
//        user.setAddr(requestDto.getAddr());
//        user.setEmail(requestDto.getEmail());
//        user.setGender(requestDto.getGender());
//        user.setRole("ROLE_USER");
//        user.setIslocked(false);
//        user.setMembership("일반");
//
//        userRepository.save(user);
//
//        return true;
//    }

    @Value("${jwt.secret}")
    private String secretKey;

    private Long expiredMs = 1000 * 60 * 60l;


    @Transactional(rollbackFor=Exception.class)
    public boolean userAdultJoin(UserAdultJoinRequest requestDto){
        User user = new User();
        user.setUserName(requestDto.getUserName());
        user.setPassword(encoder.encode(requestDto.getPassword()));
        user.setRealname(requestDto.getRealname());
        user.setBirth(requestDto.getBirth());
        user.setChildphone(null);
        user.setAdultphone(requestDto.getAdultphone());
        user.setAddr(requestDto.getAddr());
        user.setEmail(requestDto.getEmail());
        user.setGender(requestDto.getGender());
        user.setRole("ROLE_USER");
        user.setIslocked(false);
        user.setMembership("일반");

        userRepository.save(user);

        return true;
    }
    @Transactional(rollbackFor=Exception.class)
    public boolean userChildJoin(UserChildJoinRequest requestDto){


        // 사용자 등록 로직
        User user = new User();
        user.setUserName(requestDto.getUserName());
        user.setPassword(encoder.encode(requestDto.getPassword()));
        user.setRealname(requestDto.getRealname());
        user.setBirth(requestDto.getBirth());
        user.setChildphone(requestDto.getChildphone());
        user.setAdultphone(requestDto.getAdultphone());
        user.setAddr(requestDto.getAddr());
        user.setEmail(requestDto.getEmail());
        user.setGender(requestDto.getGender());
        user.setRole("ROLE_USER");
        user.setIslocked(false);
        user.setMembership("일반");

        userRepository.save(user);

        return true;
    }

}





//    public String login(String userName, String password) {
//
//        // userName 없음
//        User selectedUser = userRepository.findByUserName(userName)
//                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND,userName + "이 없습니다"));
//
//        // password 없음
//        if(!encoder.matches(password,selectedUser.getPassword())) {
//            throw new AppException(ErrorCode.INVALID_PASSWORD,"패스워드를 잘못 입력했습니다.");
//        }
//
//        // 앞에서 Exception 안났으면 토큰 발행
//        String token = JwtUtil.createJwt(selectedUser.getUserName(),selectedUser.getRole(),secretKey,expiredMs);
//
//        LoginedUser loginedUser = new LoginedUser();
//        loginedUser.setUserName(selectedUser.getUserName());
//        loginedUser.setRole(selectedUser.getRole());
//        loginedUser.setToken("Bearer" +token);
//
//        loginedUserRepository.save(loginedUser);
//
//        return token;
////        JwtUtil.createJwt(userName,secretKey,expiredMs);
//    }



