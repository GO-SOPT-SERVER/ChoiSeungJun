package sopt.org.SecondSeminar.service;


import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.domain.post.PostRequestDto;
import sopt.org.SecondSeminar.domain.post.PostResponseDto;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {

    public Long save(PostRequestDto requestDto) {
        Post post = Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .build();

        postList.add(post);
        post.setPostId((long) postList.size());

        return post.getPostId();
    }

    public PostResponseDto findById(Long postId) {
        Post post = postList.get(postId.intValue() - 1);

        PostResponseDto responseDto = PostResponseDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .build();

        return responseDto;
    }
}
