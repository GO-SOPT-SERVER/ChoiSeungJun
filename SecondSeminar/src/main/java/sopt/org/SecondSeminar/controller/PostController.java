package sopt.org.SecondSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.domain.post.PostRequestDto;
import sopt.org.SecondSeminar.domain.post.PostResponseDto;
import sopt.org.SecondSeminar.service.PostService;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public String savePost(@RequestBody PostRequestDto request) {
        Long postId = postService.save(request);
        return postId + "번 게시물 등록 완료!";
    }

    @GetMapping("{postId}")
    public String findPostByPath(@PathVariable Long postId) {
        PostResponseDto response = postService.findById(postId);
        return postId + "번 게시물 조회 성공!\n" + response;
    }

    @GetMapping("search")
    public String findPostByParam(@RequestParam Long postId) {
        PostResponseDto response = postService.findById(postId);
        return postId + "번 게시물 조회 성공!\n" + response;
    }


}
