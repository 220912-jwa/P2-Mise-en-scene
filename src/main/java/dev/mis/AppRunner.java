package dev.mis;

import dev.mis.controllers.AuthenticationController;
import dev.mis.controllers.LibraryEntryController;
import dev.mis.controllers.MovieController;
import dev.mis.controllers.UserController;
import dev.mis.daos.LibraryEntryDAO;
import dev.mis.daos.MovieDAO;
import dev.mis.daos.UserDAO;
import dev.mis.services.AuthenticationService;
import dev.mis.services.LibraryEntryService;
import dev.mis.services.MovieService;
import dev.mis.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.path;

public class AppRunner {
    public static void main(String[] args) {
        //dependency injection
        UserDAO userDAO = new UserDAO();
        MovieDAO movieDAO = new MovieDAO();
        LibraryEntryDAO libraryEntryDAO = new LibraryEntryDAO();

        UserService us = new UserService(userDAO, movieDAO);
        MovieService ms = new MovieService(movieDAO);
        LibraryEntryService ls = new LibraryEntryService(userDAO,movieDAO,libraryEntryDAO);
        AuthenticationService as = new AuthenticationService(userDAO);

        UserController uc = new UserController(us);
        MovieController mc = new MovieController(ms);
        LibraryEntryController lc = new LibraryEntryController(ls);
        AuthenticationController ac = new AuthenticationController(as);

        Javalin mis = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.addStaticFiles("/public", Location.CLASSPATH);
        }).start(8080);
        //starts app on localhost

        mis.routes(()->{
            path("/authenticate", () -> {
                post(ac.login);
            });

            path("/{user_id}", () -> {
                delete(uc::deleteUser);
                //user controller method endpoints go here
                path("/{movie_id}", () -> {
                    delete(lc::deleteLibraryEntry);
                });
                path("/library", () -> {
                    get(lc::getLibraryForUser);
                    post(lc::createLibraryEntry);
                    put(lc::updateLibraryEntry);
                });
            });
            path("/{user_code}", () -> {
                get(lc::getLibraryForCode);
                //this is for Profile View
            });
            path("/movies",() -> {
                post(mc::createMovie);
                //movie id put last to avoid confusion even though there is no overlap between movie and user IDs
                path("/{movie_id}", ()->{
                    get(mc::searchMovieById);
                    delete(mc::deleteMovie);
                    put(mc::updateMovie);
                });
            });
        });

        mis.get("/getSession", ctx -> {
            if (ctx.sessionAttribute("loggedInUser") != null ){
                ctx.json(ctx.sessionAttribute("loggedInUser"));
            }
        });//session manager




    }
}
