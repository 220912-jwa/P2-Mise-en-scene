package dev.mis.controllers;

import dev.mis.entities.Movie;
import dev.mis.entities.User;
import dev.mis.services.UserService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
    this.userService = userService;
}
    public void getMovieById(Context ctx) {

    int Id = Integer.parseInt(ctx.pathParam("movie_id"));
    Movie mv = userService.getMovieById(movieID);

    if (mv != null) {
        ctx.status(200);
        ctx.json(mv);
    }
    }
    public void getAllUsers(Context ctx) {
        if (ctx.sessionAttribute("loggedInUser")) {

            User user = ctx.sessionAttribute("loggedInUser");
            System.out.println(user);
            ctx.status(200);
            ctx.json(userService.getAllUsers());
        }
        else{
            System.out.println("sorry");
            ctx.status(HttpCode.UNAUTHORIZED);
        }
    }
    public void getUserById(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("id"));

        User user = userService.getuserById(userId);


        if (user != null) {
            ctx.status(HttpCode.OK);
            ctx.json(user);
        }
    }
    public void updateUser(Context ctx) {
        User toBeUpdated = ctx.bodyAsClass(User.class);
        userService.updateUser(toBeUpdated);
        ctx.status(HttpCode.NO_CONTENT);
    }
    public void deleteUser(Context ctx) {
        int userId = Integer.parseInt(ctx.pathParam("user_id"));
        userService.deleteUser(userId);
    }


    }
