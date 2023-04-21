package sopt.org.secondSeminarAdvancedAssignment.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import sopt.org.secondSeminarAdvancedAssignment.domain.User;

import java.util.Optional;

import static sopt.org.secondSeminarAdvancedAssignment.repository.UserSequence.userSeq;

@Repository
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    @Override
    public void save(User user) {
        userData.put(++userSeq, user);
    }

    @Override
    public Optional<User> find(Long userId) {
        Optional<User> user;
        try {
            user = Optional.of(userData.get(userId));
        } catch (Exception e) {
            user = Optional.empty();
        }

        return user;
    }

    @Override
    public void update(Long userId, User user) {
        userData.replace(userId, user);
        System.out.println("userData.get(userId) = " + userData.get(userId).getName());
    }
}
