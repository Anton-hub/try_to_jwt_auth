package ru.saushkin.anton.util;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import ru.saushkin.anton.security.entity.User;

import java.util.Date;

@Component
public class JWTUtil {

    public String getToken(User user){
        /**
         * The setting is valid for two minutes, adding the parameter withClaim, and setting the expiration time withExpiresAt.
         * Use personal password as key
         */
        Date date = new Date(System.currentTimeMillis()+1000*60*2);
        String token = JWT.create()
                .withAudience(user.getId()).withClaim("city", "XM").withExpiresAt(date)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
