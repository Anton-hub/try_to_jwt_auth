package ru.saushkin.anton.services;

import org.springframework.stereotype.Service;
import ru.saushkin.anton.security.entity.User;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public User findUserById(String userId) {
        User user = new User();
        user.setId("1");
        user.setUsername("admin");
        user.setPassword("admin");
        return user;
    }

    @Override
    public User findByUsername(User user) {
        User u = new User();
        u.setId("1");
        u.setUsername("admin");
        u.setPassword("admin");
        return u;
    }

}
