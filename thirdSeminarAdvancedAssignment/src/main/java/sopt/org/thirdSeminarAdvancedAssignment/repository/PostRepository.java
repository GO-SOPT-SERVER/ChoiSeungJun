package sopt.org.thirdSeminarAdvancedAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.thirdSeminarAdvancedAssignment.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
