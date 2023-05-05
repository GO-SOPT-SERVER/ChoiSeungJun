package sopt.org.thirdSeminarAdvancedAssignment.dto.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class PostRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private Long userId;

}
