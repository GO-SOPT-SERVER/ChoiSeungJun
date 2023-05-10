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
    private String password;
    private String email;

    public static UserResponseDto of(Long userId, String username, String password, String email) {
        return UserResponseDto.builder()
                .userId(userId)
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}
