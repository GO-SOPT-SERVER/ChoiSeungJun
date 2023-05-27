package sopt.org.fourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.fourthSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.fourthSeminar.controller.dto.request.UserRequestDto;
import sopt.org.fourthSeminar.controller.dto.response.UserLoginResponseDto;
import sopt.org.fourthSeminar.controller.dto.response.UserResponseDto;
import sopt.org.fourthSeminar.controller.exception.Error;
import sopt.org.fourthSeminar.controller.exception.model.ConflictException;
import sopt.org.fourthSeminar.controller.exception.model.NotFoundException;
import sopt.org.fourthSeminar.domain.User;
import sopt.org.fourthSeminar.infrastructure.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

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

    public UserLoginResponseDto login(UserLoginRequestDto request) {
        User user = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Long userId = user.getId();
        String token = jwtService.issuedToken(userId.toString());
        return UserLoginResponseDto.of(userId, token);

    }
}
