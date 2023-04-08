package sopt.org.SecondSeminar.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.domain.UserRequestDto;
import sopt.org.SecondSeminar.service.UserService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String register(@RequestBody final UserRequestDto request) {
        Long userId = userService.register(request);
        System.out.print(userList.get(userId.intValue() - 1).toString());

        return userId + "번 유저 등록이 완료되었습니다!";
    }


    @GetMapping("/user/{userId}")
    public String getOne(@PathVariable final Long userId) {
        System.out.println("요청 유저 아이디 = " + userId);

        return "유저 조회 성공";
    }

    @GetMapping("/user/search")
    public String search(@RequestParam final Long userId) {
        System.out.println("요청 유저 아이디 = " + userId);

        return "유저 조회 성공";
    }
}
