package dev.mis.controllers;

import dev.mis.entities.User;
import dev.mis.services.AuthenticationService;
import io.javalin.http.Handler;

public class AuthenticationController {
    private AuthenticationService as;
    public AuthenticationController(AuthenticationService as){
        this.as = as;
    }

    public Handler login = ctx -> {
        User u = ctx.bodyAsClass(User.class);
        User authenticatedU = as.userLogin(u.getUsername(), u.getPass());
        ctx.sessionAttribute("loggedInUser", authenticatedU);
        if (authenticatedU != null){
            ctx.status(200);
            ctx.json(authenticatedU);
        }//refactored to new class as UserController needs to call UserService, which will end up needing all 3 DAOs (get all movies for user)
        //We could refactor in another way that would let login live in the same classes as UserService, but the code is already set up to make them separate
    };
}
