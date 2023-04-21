package sopt.org.secondSeminarAdvancedAssignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.secondSeminarAdvancedAssignment.domain.User;
import sopt.org.secondSeminarAdvancedAssignment.dto.UserRequestDto;
import sopt.org.secondSeminarAdvancedAssignment.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveUser(UserRequestDto userDto) {
        userRepository.save(userDto.from());
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return userRepository.find(userId);
    }
}
