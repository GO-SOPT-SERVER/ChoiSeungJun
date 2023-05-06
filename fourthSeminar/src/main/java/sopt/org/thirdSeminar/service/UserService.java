package sopt.org.thirdSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.thirdSeminar.controller.dto.request.UserRequestDto;
import sopt.org.thirdSeminar.controller.dto.response.UserResponseDto;
import sopt.org.thirdSeminar.domain.User;
import sopt.org.thirdSeminar.infrastructure.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto request) {
        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        userRepository.save(user);

        return UserResponseDto.of(user.getId(), user.getNickname());
    }

}
