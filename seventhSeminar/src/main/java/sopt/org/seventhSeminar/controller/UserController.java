package sopt.org.seventhSeminar.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.seventhSeminar.controller.common.dto.ApiResponse;
import sopt.org.seventhSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.seventhSeminar.controller.dto.request.UserRequestDto;
import sopt.org.seventhSeminar.controller.dto.response.UserLoginResponseDto;
import sopt.org.seventhSeminar.controller.dto.response.UserResponseDto;
import sopt.org.seventhSeminar.controller.exception.Success;
import sopt.org.seventhSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "유저 회원가입 API", description = "유저가 서버에 회원가입을 요청합니다.")
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "유저 로그인 API", description = "유저가 서버에 로그인을 요청합니다.")
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        return ApiResponse.success(Success.LOGIN_SUCCESS, userService.login(request));
    }
}