package dev.chrono.chronochallenge.auth.controller;


import dev.chrono.chronochallenge.auth.dto.AuthInfo;
import dev.chrono.chronochallenge.common.dto.MessageResponse;
import dev.chrono.chronochallenge.auth.dto.request.LoginRequest;
import dev.chrono.chronochallenge.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // TODO: 요청 받은 아이디가 데이터에 있는지 확인한다.
    // TODO: 로그인 요청을 했을 떄 아이디와 비밀번호가 일치한지 확인한다.
    // TODO: 일치하면 로그인 =>  로그인시 세션ID를 생성 => 보내준다.

    @PostMapping("/login")
    public ResponseEntity<AuthInfo> login(@Valid @RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {
        AuthInfo autoInfo = authService.login(loginRequest);
        HttpSession session = request.getSession();
        session.setAttribute("memberId", autoInfo);
        System.out.println("로그인 성공");
        return new ResponseEntity<>(autoInfo, HttpStatus.ACCEPTED);
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        AuthInfo authInfo = (AuthInfo) session.getValue("memberId");
        System.out.println(authInfo.getName() + "로그아웃");
        session.invalidate();
    }

    @GetMapping("/login_check")
    public ResponseEntity<MessageResponse> loginCheck(HttpSession session) {
        MessageResponse messageResponse = authService.loginCheck(session);

        return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
    }

}