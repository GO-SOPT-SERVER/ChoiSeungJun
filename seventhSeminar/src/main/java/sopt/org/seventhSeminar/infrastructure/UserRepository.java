package sopt.org.seventhSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.seventhSeminar.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    // CREATE
    void save(User user);

    // READ
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long userId);
    boolean existsByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    // UPDATE

    // DELETE
}
