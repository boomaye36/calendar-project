package com.example.calendarapi.service;

import com.example.calendarapi.dto.LoginReq;
import com.example.calendarapi.dto.SignUpReq;
import com.example.calendarcore.domain.entity.User;
import com.example.calendarcore.dto.UserCreateReq;
import com.example.calendarcore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserService userService;
    public final static String LOGIN_SESSION_KEY = "USER_ID";
    /**
     * UserService에 Create을 담당한다. (이미 존재하는 경우의 유저 검정은 UserService에서 함) (Application layer 일만 함)
     * 생성이 되면 session에 담고 리턴
     */

    /**
     * 세션 값이 있으면 리턴
     * 세션 값이 ㅇ벗으면 비밀번호 체크 후에 로그인 & 세션에 담고 리턴
     * @param signUpReq
     * @param session
     */
    @Transactional
    public void signUp(SignUpReq signUpReq, HttpSession session){

        final User user = userService.create(new UserCreateReq(
                signUpReq.getName(),
                signUpReq.getEmail(),
                signUpReq.getPassword(),
                signUpReq.getBirthday()

        ));
        session.setAttribute(LOGIN_SESSION_KEY, user.getId());
    }

    @Transactional
    public void login(LoginReq loginReq, HttpSession session){
        final Long userId = (Long) session.getAttribute(LOGIN_SESSION_KEY);
        if(userId != null) return;
        final Optional<User> user =  userService.findPwMatchUser(loginReq.getEmail(),
                loginReq.getPassword());
        if (user.isPresent()) session.setAttribute(LOGIN_SESSION_KEY, user.get().getId());
        else throw new RuntimeException("password or email not match");

    }

    public void logout(HttpSession session){
        session.removeAttribute(LOGIN_SESSION_KEY);
    }
}
