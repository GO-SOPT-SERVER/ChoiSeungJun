package sopt.org.thirdSeminarAdvancedAssignment.dto.post;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PostRequestDto {

    @NotNull
    private Long userId;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    @Builder
    public PostRequestDto(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
