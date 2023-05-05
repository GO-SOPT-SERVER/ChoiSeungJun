package sopt.org.thirdSeminarAdvancedAssignment.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDto {

    private Long userId;
    private String username;
    private int age;

    public static UserResponseDto of(Long userId, String username, int age) {
        return UserResponseDto.builder()
                .userId(userId)
                .username(username)
                .age(age)
                .build();
    }
}
