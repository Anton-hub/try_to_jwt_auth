package ru.saushkin.anton.security.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.saushkin.anton.security.UserRepo;
import ru.saushkin.anton.security.domain.User;
import ru.saushkin.anton.security.domain.UserView;

import java.util.List;

@Component
public abstract class UserViewMapper {

    @Autowired
    private UserRepo userRepo;

    public abstract UserView toUserView(User user);

    public abstract List<UserView> toUserView(List<User> users);

    public UserView toUserViewById(String id) {
        if (id == null) {
            return null;
        }
        return toUserView(userRepo.getById(id));
    }

}
