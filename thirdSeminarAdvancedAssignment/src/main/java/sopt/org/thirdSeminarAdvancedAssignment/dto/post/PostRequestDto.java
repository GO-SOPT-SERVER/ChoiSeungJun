package sopt.org.thirdSeminarAdvancedAssignment.dto.post;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
