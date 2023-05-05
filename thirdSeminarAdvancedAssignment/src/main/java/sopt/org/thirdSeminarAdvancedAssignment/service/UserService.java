package sopt.org.thirdSeminarAdvancedAssignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.thirdSeminarAdvancedAssignment.domain.User;
import sopt.org.thirdSeminarAdvancedAssignment.dto.UserRequestDto;
import sopt.org.thirdSeminarAdvancedAssignment.dto.UserResponseDto;
import sopt.org.thirdSeminarAdvancedAssignment.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto insertUser(UserRequestDto userRequestDto) {
        User user = User.of(userRequestDto.getUsername(), userRequestDto.getAge());
        User savedUser = userRepository.save(user);

        return UserResponseDto.of(savedUser.getUserId(), user.getUsername(), user.getAge());
    }
}
