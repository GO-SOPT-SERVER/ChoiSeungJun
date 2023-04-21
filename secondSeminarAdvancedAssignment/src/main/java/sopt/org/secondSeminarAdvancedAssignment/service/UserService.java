package sopt.org.secondSeminarAdvancedAssignment.service;

import sopt.org.secondSeminarAdvancedAssignment.domain.User;
import sopt.org.secondSeminarAdvancedAssignment.dto.UserRequestDto;
import sopt.org.secondSeminarAdvancedAssignment.dto.UserResponseDto;

import java.util.Optional;

public interface UserService{

    void saveUser(UserRequestDto userDto);

    Optional<User> findUserById(Long userId);

    boolean updateUser(Long userId, UserRequestDto userDto);
}
