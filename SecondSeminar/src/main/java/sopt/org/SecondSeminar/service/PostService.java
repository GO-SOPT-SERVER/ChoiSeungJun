package sopt.org.SecondSeminar.service;


import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.domain.post.PostRequestDto;
import sopt.org.SecondSeminar.domain.post.PostResponseDto;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {

    public Long save(PostRequestDto requestDto) {
        Post post = new Post(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getAuthor());

        postList.add(post);

        post.setPostId((long) postList.size());
        return post.getPostId();
    }

    public PostResponseDto findById(Long postId) {
        Post post = postList.get(postId.intValue() - 1);

        PostResponseDto responseDto = new PostResponseDto(
                post.getPostId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor());

        return responseDto;
    }
}
