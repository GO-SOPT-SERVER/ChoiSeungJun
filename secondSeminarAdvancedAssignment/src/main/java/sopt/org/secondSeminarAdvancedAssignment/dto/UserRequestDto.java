package sopt.org.secondSeminarAdvancedAssignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.secondSeminarAdvancedAssignment.domain.User;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequestDto {
    private String name;
    private Integer age;


    public User from() {
        return User.builder()
                .name(name)
                .age(age)
                .build();
    }
}
