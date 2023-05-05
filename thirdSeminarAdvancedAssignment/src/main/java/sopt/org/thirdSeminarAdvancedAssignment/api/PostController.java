package sopt.org.thirdSeminarAdvancedAssignment.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.thirdSeminarAdvancedAssignment.dto.post.PostRequestDto;
import sopt.org.thirdSeminarAdvancedAssignment.dto.post.PostResponseDto;
import sopt.org.thirdSeminarAdvancedAssignment.exception.ApiResponseDto;
import sopt.org.thirdSeminarAdvancedAssignment.exception.SuccessStatus;
import sopt.org.thirdSeminarAdvancedAssignment.service.PostService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<PostResponseDto> create(@RequestBody @Valid final PostRequestDto postRequestDto) {
        return ApiResponseDto.success(SuccessStatus.POST_SUCCESS, postService.addPost(postRequestDto));
    }
}
