package sopt.org.secondSeminarAdvancedAssignment.repository;

import org.springframework.stereotype.Repository;
import sopt.org.secondSeminarAdvancedAssignment.domain.User;

import static sopt.org.secondSeminarAdvancedAssignment.repository.UserSequence.userSeq;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public void save(User user) {
        userData.put(++userSeq, user);
    }
}
