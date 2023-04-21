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
public class UserController extends ResponseEntityGenerator{
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDto userRequestDto) {
        boolean saveResult = userService.saveUser(userRequestDto);

        return generateSaveResponseEntity(saveResult);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> findUser(@PathVariable Long userId) {
        Optional<User> findUser = userService.findUserById(userId);

        return generateFindResponseEntity(findUser, userId);
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


    @Override
    public ResponseEntity<?> generateFindResponseEntity(Optional<?> user, Long userId) {
        return (user.isEmpty()) ?
                new ResponseEntity<>(userId + "번 유저에 대한 정보가 존재하지 않습니다.", HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(((User)user.get()).toDto(userId), HttpStatus.OK);
    }

}
