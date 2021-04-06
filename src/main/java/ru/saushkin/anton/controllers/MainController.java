package ru.saushkin.anton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.saushkin.anton.services.MainService;

@RestController
public class MainController {

    MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping("/hello")
    public String index() {
        return mainService.getHelloResponse();
    }

}