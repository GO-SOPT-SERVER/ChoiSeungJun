package sopt.org.thirdSeminarAdvancedAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.thirdSeminarAdvancedAssignment.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

}
