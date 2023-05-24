package sopt.org.fourthSeminar.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSeminar.config.resolver.UserId;
import sopt.org.fourthSeminar.controller.common.dto.ApiResponse;
import sopt.org.fourthSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.fourthSeminar.controller.exception.Success;
import sopt.org.fourthSeminar.service.BoardService;
import sopt.org.fourthSeminar.service.JwtService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId final String accessToken,
            @RequestBody @Valid final BoardRequestDto request) {

        boardService.create(Long.parseLong(jwtService.getJwtContents(accessToken)), request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}