package sopt.org.secondSeminarAdvancedAssignment.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private Integer age;
}
