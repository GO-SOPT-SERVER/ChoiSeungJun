package sopt.org.secondSeminarAdvancedAssignment.repository;

import sopt.org.secondSeminarAdvancedAssignment.domain.User;

import java.util.HashMap;
import java.util.Map;

public interface UserRepository {
    Map<Long, User> userData = new HashMap<>();

    void save(User user);
}
