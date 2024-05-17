package com.aslam.springboot.myfirstwebapp.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean isValidUsername = username.equalsIgnoreCase("aslam");
        boolean isPasswordValid = password.equalsIgnoreCase("dummy");
        return isValidUsername & isPasswordValid;
    }
}
