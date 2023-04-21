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

    @Override
    public boolean updateUser(Long userId, UserRequestDto updateDto) {
        boolean updateResult = true;

        Optional<User> user = userRepository.find(userId);

        if(user.isEmpty()) {
            updateResult = false;
            return updateResult;
        }

        User updatedUser = user.get();
        updatedUser.update(updateDto);

        userRepository.update(userId, updatedUser);

        return updateResult;
    }

    @Override
    public boolean deleteUser(Long userId) {
        boolean deleteResult = true;

        Optional<User> user = userRepository.find(userId);

        if(user.isEmpty()) {
            deleteResult = false;
            return deleteResult;
        }

        userRepository.delete(userId);
        return deleteResult;
    }
}
