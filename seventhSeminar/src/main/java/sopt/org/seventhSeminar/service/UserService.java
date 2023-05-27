package sopt.org.seventhSeminar.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.seventhSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.seventhSeminar.controller.dto.request.UserRequestDto;
import sopt.org.seventhSeminar.controller.dto.response.UserLoginResponseDto;
import sopt.org.seventhSeminar.controller.dto.response.UserResponseDto;
import sopt.org.seventhSeminar.controller.exception.Error;
import sopt.org.seventhSeminar.controller.exception.model.ConflictException;
import sopt.org.seventhSeminar.controller.exception.model.NotFoundException;
import sopt.org.seventhSeminar.domain.User;
import sopt.org.seventhSeminar.infrastructure.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
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
