package sopt.org.thirdSeminarAdvancedAssignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.thirdSeminarAdvancedAssignment.domain.Post;
import sopt.org.thirdSeminarAdvancedAssignment.domain.User;
import sopt.org.thirdSeminarAdvancedAssignment.dto.post.PostRequestDto;
import sopt.org.thirdSeminarAdvancedAssignment.dto.post.PostResponseDto;
import sopt.org.thirdSeminarAdvancedAssignment.dto.user.UserRequestDto;
import sopt.org.thirdSeminarAdvancedAssignment.dto.user.UserResponseDto;
import sopt.org.thirdSeminarAdvancedAssignment.repository.PostRepository;
import sopt.org.thirdSeminarAdvancedAssignment.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostResponseDto addPost(PostRequestDto postRequestDto) {
        User user = userRepository.findById(postRequestDto.getUserId()).orElseThrow();
        Post post = Post.of(postRequestDto.getTitle(), postRequestDto.getContent(), user);
        Post savedPost = postRepository.save(post);

        return PostResponseDto.of(savedPost.getPostId(), savedPost.getTitle(), savedPost.getContent(), user.getUsername());
    }
}
