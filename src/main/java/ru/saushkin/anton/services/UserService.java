package ru.saushkin.anton.services;

import ru.saushkin.anton.security.entity.User;

public interface UserService {
    User findUserById(String userId);
    User findByUsername(User user);
}
