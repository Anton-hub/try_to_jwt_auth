package ru.saushkin.anton.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.saushkin.anton.security.UserLoginToken;
import ru.saushkin.anton.security.entity.User;
import ru.saushkin.anton.services.UserService;
import ru.saushkin.anton.util.JWTUtil;

@RestController
@RequestMapping("api")
public class TestController {


    UserService userService;
    JWTUtil tokenService;

    @Autowired
    public TestController(UserService userService, JWTUtil tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    //Log in
    @PostMapping("/login")
    public Object login(@RequestBody User user){

        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findByUsername(user);
        if (userForBase == null) {
            jsonObject.put("message","Login failed, user does not exist");
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message","Login failed, wrong password");
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
            }
        }
        return jsonObject;
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "You have passed verification";
    }
}
