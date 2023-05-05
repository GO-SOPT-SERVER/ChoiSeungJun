package sopt.org.thirdSeminarAdvancedAssignment.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class PostResponseDto {

    private Long postId;
    private String title;
    private String content;
    private String username;

    public static PostResponseDto of(Long postId, String title, String content, String username) {
        return PostResponseDto.builder()
                .postId(postId)
                .content(content)
                .title(title)
                .username(username)
                .build();
    }
}
