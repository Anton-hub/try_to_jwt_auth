package ru.saushkin.anton.services;

import org.springframework.stereotype.Service;

@Service
public class MainService {

    public String getHelloResponse() {
        return "Hello!";
    }

}
