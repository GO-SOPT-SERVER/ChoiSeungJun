package sopt.org.thirdSeminarAdvancedAssignment.dto.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserRequestDto {

    @NotBlank
    @Pattern(regexp = "^[가-힣a-zA-Z]{2,10}$", message = "닉네임 형식에 맞지 않습니다.")
    private String username;

    @NotBlank
    @Pattern(regexp = "^[a-zA-z0-9]{8,12}$")
    private String password;

    @NotBlank
    @Pattern(regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @Builder
    public UserRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}