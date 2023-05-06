package sopt.org.SecondSeminar.domain;

import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String gender;
    private String name;
    private int age;
    private String contact;

    public User(String gender, String name, int age, String contact) {
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'';
    }
}
