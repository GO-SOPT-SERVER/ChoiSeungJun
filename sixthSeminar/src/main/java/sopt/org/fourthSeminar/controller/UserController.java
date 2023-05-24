package sopt.org.fourthSeminar.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSeminar.controller.common.dto.ApiResponse;
import sopt.org.fourthSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.fourthSeminar.controller.dto.request.UserRequestDto;
import sopt.org.fourthSeminar.controller.dto.response.UserLoginResponseDto;
import sopt.org.fourthSeminar.controller.dto.response.UserResponseDto;
import sopt.org.fourthSeminar.controller.exception.Success;
import sopt.org.fourthSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        return ApiResponse.success(Success.LOGIN_SUCCESS, userService.login(request));
    }
}