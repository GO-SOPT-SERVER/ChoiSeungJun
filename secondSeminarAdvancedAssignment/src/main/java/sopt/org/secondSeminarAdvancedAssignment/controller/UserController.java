package sopt.org.secondSeminarAdvancedAssignment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.secondSeminarAdvancedAssignment.dto.UserRequestDto;
import sopt.org.secondSeminarAdvancedAssignment.service.UserService;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDto userRequestDto) {
        userService.saveUser(userRequestDto);
        return ResponseEntity.ok("유저 저장 완료");
    }

}
