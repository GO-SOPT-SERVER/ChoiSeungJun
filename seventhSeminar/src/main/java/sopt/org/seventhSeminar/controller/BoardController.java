package sopt.org.seventhSeminar.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sopt.org.seventhSeminar.aws.S3Service;
import sopt.org.seventhSeminar.config.resolver.UserId;
import sopt.org.seventhSeminar.controller.common.dto.ApiResponse;
import sopt.org.seventhSeminar.controller.dto.request.BoardImageListRequestDto;
import sopt.org.seventhSeminar.controller.exception.Success;
import sopt.org.seventhSeminar.service.BoardService;
import sopt.org.seventhSeminar.service.JwtService;

import javax.validation.Valid;
import java.util.List;

@RestController
@SecurityRequirement(name = "JWT Auth")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final JwtService jwtService;
    private final S3Service s3Service;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @ModelAttribute @Valid final BoardImageListRequestDto request) {
        List<String> boardThumbnailImageUrlList = s3Service.uploadImages(request.getBoardImages(), "board");
        boardService.create(userId, boardThumbnailImageUrlList, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}