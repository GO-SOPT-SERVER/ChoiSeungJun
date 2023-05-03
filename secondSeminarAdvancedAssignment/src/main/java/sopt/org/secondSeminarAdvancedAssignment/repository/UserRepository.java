package sopt.org.secondSeminarAdvancedAssignment.repository;

import sopt.org.secondSeminarAdvancedAssignment.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface UserRepository {
    Map<Long, User> userData = new HashMap<>();

    void save(User user);

    Optional<User> find(Long userId);

    void update(Long userId, User user);

    void delete(Long userId);
}
