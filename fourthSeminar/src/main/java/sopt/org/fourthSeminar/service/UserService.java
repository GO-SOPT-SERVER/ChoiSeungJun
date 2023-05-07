package sopt.org.fourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.fourthSeminar.controller.dto.request.UserRequestDto;
import sopt.org.fourthSeminar.controller.dto.response.UserResponseDto;
import sopt.org.fourthSeminar.controller.exception.Error;
import sopt.org.fourthSeminar.controller.exception.model.ConflictException;
import sopt.org.fourthSeminar.domain.User;
import sopt.org.fourthSeminar.infrastructure.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException(Error.ALREADY_EXIST_USER_EXCEPTION, Error.ALREADY_EXIST_USER_EXCEPTION.getMessage());
        }

        User newUser = User.newInstance(
                request.getNickname(),
                request.getEmail(),
                request.getPassword()
        );

        userRepository.save(newUser);

        return UserResponseDto.of(newUser.getId(), newUser.getNickname());
    }
}
