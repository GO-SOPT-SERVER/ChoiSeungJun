package sopt.org.secondSeminarAdvancedAssignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private Integer age;
}
