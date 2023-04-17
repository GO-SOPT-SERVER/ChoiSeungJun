package sopt.org.SecondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.domain.User;
import sopt.org.SecondSeminar.domain.UserRequestDto;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

@Service
public class UserService {

    public Long register(UserRequestDto request) {

        User newUser = new User(
                request.getGender(),
                request.getName(),
                request.getAge(),
                request.getContact()
        );

        userList.add(newUser);
        newUser.setId((long) userList.size());

        return newUser.getId();

    }
}
