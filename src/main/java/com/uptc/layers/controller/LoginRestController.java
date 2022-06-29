package com.uptc.layers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.uptc.layers.model.entity.User;
import com.uptc.layers.model.object.JwtTokenValidation;
import com.uptc.layers.model.object.LoginCredentials;
import com.uptc.layers.model.service.UserService;
import com.uptc.layers.security.Jwt;
import com.uptc.layers.security.Jwt.JwtToken;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class LoginRestController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public JwtToken login(@RequestBody LoginCredentials loginCredentials) {
        if (this.userService.verifyUserWithEmailAndPassword(loginCredentials.email, loginCredentials.password)) {
            return new JwtToken(loginCredentials);
        } else {
            return null;
        }
    }

    @PostMapping("/validate-jwt")
    public Boolean validateJwt(@RequestBody JwtTokenValidation jwtTokenValidation) {
        if (jwtTokenValidation.value == null) {
            return false;
        }

        DecodedJWT validatedJwt = Jwt.isJwtTokenValid(jwtTokenValidation.value);
        if (validatedJwt != null) {
            LoginCredentials credentials = Jwt.getLoginCredentialsFromToken(validatedJwt);
            return this.userService.verifyUserWithEmailAndPassword(credentials.email, credentials.password);
        } else {
            return false;
        }
    }

    @PostMapping("/user-from-jwt")
    public User getUserFromJwt(@RequestBody JwtTokenValidation jwtTokenValidation) {
        DecodedJWT validatedJwt = Jwt.isJwtTokenValid(jwtTokenValidation.value);
        LoginCredentials credentials = Jwt.getLoginCredentialsFromToken(validatedJwt);
        return this.userService.findOneByEmail(credentials.email);
    }
}
