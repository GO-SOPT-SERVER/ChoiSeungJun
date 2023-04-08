package sopt.org.SecondSeminar.domain.post;


import lombok.Getter;

@Getter
public class Post {

    private Long postId;
    private String title;
    private String content;
    private String author;


    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
