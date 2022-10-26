package dev.mis.controllers;

import dev.mis.entities.User;
import dev.mis.services.AuthenticationService;
import dev.mis.services.UserService;
import io.javalin.http.Handler;

public class UserController {

    private UserService us;

    public UserController(UserService us){
        this.us = us;
    }




}
