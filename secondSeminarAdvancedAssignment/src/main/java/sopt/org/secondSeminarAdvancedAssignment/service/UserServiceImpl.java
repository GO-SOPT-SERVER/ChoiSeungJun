package sopt.org.secondSeminarAdvancedAssignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.secondSeminarAdvancedAssignment.dto.UserRequestDto;
import sopt.org.secondSeminarAdvancedAssignment.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveUser(UserRequestDto userDto) {
        userRepository.save(userDto.from());
    }
}
