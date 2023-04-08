package sopt.org.SecondSeminar.domain.post;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponseDto {

    private Long postId;
    private String title;
    private String content;
    private String author;

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'';
    }
}
