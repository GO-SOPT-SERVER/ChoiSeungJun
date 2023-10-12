package sopt.org.thirdSeminarAdvancedAssignment.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.thirdSeminarAdvancedAssignment.dto.user.UserRequestDto;
import sopt.org.thirdSeminarAdvancedAssignment.dto.user.UserResponseDto;
import sopt.org.thirdSeminarAdvancedAssignment.exception.ApiResponse;
import sopt.org.thirdSeminarAdvancedAssignment.exception.SuccessStatus;
import sopt.org.thirdSeminarAdvancedAssignment.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto userRequestDto) {
        return ApiResponse.success(SuccessStatus.SIGNUP_SUCCESS, userService.insertUser(userRequestDto));
    }
}
