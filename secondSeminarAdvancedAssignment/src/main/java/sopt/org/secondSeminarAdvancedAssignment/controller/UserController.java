package sopt.org.secondSeminarAdvancedAssignment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.org.secondSeminarAdvancedAssignment.domain.User;
import sopt.org.secondSeminarAdvancedAssignment.dto.UserRequestDto;
import sopt.org.secondSeminarAdvancedAssignment.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping(value = "user", produces = "application/json; charset=UTF8")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDto userRequestDto) {
        userService.saveUser(userRequestDto);
        return new ResponseEntity("유저 저장 완료", HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> findUser(@PathVariable Long userId) {
        Optional<User> findUser = userService.findUserById(userId);

        return generateUserResponseEntity(findUser, userId);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userRequestDto) {
        boolean updateResult = userService.updateUser(userId, userRequestDto);

        return generateUpdateResponseEntity(updateResult, userId);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId) {
        boolean deleteResult = userService.deleteUser(userId);

        return generateDeleteResponseEntity(deleteResult, userId);
    }




    private ResponseEntity<?> generateUserResponseEntity(Optional<User> user, Long userId) {
        return (user.isEmpty()) ?
                new ResponseEntity<>(userId + "번 유저에 대한 정보가 존재하지 않습니다.", HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(user.get().toDto(userId), HttpStatus.OK);
    }

    private ResponseEntity<?> generateUpdateResponseEntity(boolean updateResult, Long userId) {
        return (updateResult) ?
                new ResponseEntity<>(userId + "번 유저에 대한 정보가 성공적으로 업데이트 되었습니다.", HttpStatus.OK):
                new ResponseEntity<>(userId + "번 유저에 대한 정보가 존재하지 않습니다.", HttpStatus.NO_CONTENT);
    }

    private ResponseEntity<?> generateDeleteResponseEntity(boolean deleteResult, Long userId) {
        return (deleteResult) ?
                new ResponseEntity<>(userId + "번 유저에 대한 정보가 성공적으로 삭제 되었습니다.", HttpStatus.OK):
                new ResponseEntity<>(userId + "번 유저에 대한 정보가 존재하지 않습니다.", HttpStatus.NO_CONTENT);
    }

}
