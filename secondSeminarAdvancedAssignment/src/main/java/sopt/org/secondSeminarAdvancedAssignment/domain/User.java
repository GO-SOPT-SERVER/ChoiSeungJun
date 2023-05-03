package sopt.org.secondSeminarAdvancedAssignment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import sopt.org.secondSeminarAdvancedAssignment.dto.UserRequestDto;
import sopt.org.secondSeminarAdvancedAssignment.dto.UserResponseDto;

@Builder
@Getter
@AllArgsConstructor
public class User {

    private String name;
    private Integer age;

    public UserResponseDto toDto(Long userId) {
        return new UserResponseDto(userId, name, age);
    }

    public void update(UserRequestDto userRequestDto) {
        this.name = userRequestDto.getName();
        this.age = userRequestDto.getAge();
    }
}
