package sopt.org.secondSeminarAdvancedAssignment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class User {

    private String name;
    private Integer age;
}
