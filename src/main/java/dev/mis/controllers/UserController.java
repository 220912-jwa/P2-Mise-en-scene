package dev.mis.controllers;

import dev.mis.entities.User;
import dev.mis.services.AuthenticationService;
import io.javalin.http.Handler;

public class UserController {

    private AuthenticationService userAuthentication;

    public UserController(AuthenticationService userAuthentication){
        this.userAuthentication = userAuthentication;
    }

    public Handler login = ctx -> {
        User u = ctx.bodyAsClass(User.class);
        User authenticatedU = userAuthentication.userLogin(u.getUsername(), u.getPass());
        ctx.sessionAttribute("loggedInUser", authenticatedU);
        if (authenticatedU != null){
            ctx.status(200);
            ctx.json(authenticatedU);
        }
    };


}
