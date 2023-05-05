package sopt.org.thirdSeminarAdvancedAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.thirdSeminarAdvancedAssignment.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
