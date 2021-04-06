package ru.saushkin.anton.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.saushkin.anton.security.domain.User;

import java.util.Optional;

@Service
public class UserRepo {

    private final User user;

    public UserRepo() {
        user = new User();
        user.setUsername("user");
        user.setPassword("qwerty");
        user.setId("1");
    }

    public Optional<UserDetails> findByUsername(String username) {
        if (username.equals("user")) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public User getById(String id) {
        if (id.equals("1")) {
            return user;
        }
        return null;
    }
}
