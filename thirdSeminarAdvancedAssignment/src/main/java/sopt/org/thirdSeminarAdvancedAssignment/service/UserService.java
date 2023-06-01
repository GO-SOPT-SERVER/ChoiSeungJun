package sopt.org.thirdSeminarAdvancedAssignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.thirdSeminarAdvancedAssignment.domain.User;
import sopt.org.thirdSeminarAdvancedAssignment.dto.user.UserRequestDto;
import sopt.org.thirdSeminarAdvancedAssignment.dto.user.UserResponseDto;
import sopt.org.thirdSeminarAdvancedAssignment.exception.Error;
import sopt.org.thirdSeminarAdvancedAssignment.exception.model.ConflictException;
import sopt.org.thirdSeminarAdvancedAssignment.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto insertUser(UserRequestDto userRequestDto) {
        checkEmailIsExist(userRequestDto);
        checkUsernameIsExist(userRequestDto);

        User user = User.of(userRequestDto.getUsername(), userRequestDto.getPassword(), userRequestDto.getEmail());
        User savedUser = userRepository.save(user);

        return UserResponseDto.of(savedUser.getUserId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    private void checkEmailIsExist(UserRequestDto userRequestDto) {
        Optional<User> byEmail = userRepository.findByEmail(userRequestDto.getEmail());
        if(byEmail.isPresent()) {
            throw new ConflictException(Error.ALREADY_EXIST_EMAIL_EXCEPTION, Error.ALREADY_EXIST_EMAIL_EXCEPTION.getMessage());
        }
    }

    private void checkUsernameIsExist(UserRequestDto userRequestDto) {
        Optional<User> byUsername = userRepository.findByUsername(userRequestDto.getUsername());
        if(byUsername.isPresent()) {
            throw new ConflictException(Error.ALREADY_EXIST_USER_EXCEPTION, Error.ALREADY_EXIST_USER_EXCEPTION.getMessage());
        }
    }
}
