package dev.mis.controllers;

import dev.mis.daos.LibraryEntryDAO;
import dev.mis.entities.LibraryEntry;
import dev.mis.entities.Movie;
import dev.mis.services.LibraryEntryService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;


import java.util.List;

public class LibraryEntryController {
    private LibraryEntryService ls;
    public LibraryEntryController(LibraryEntryService ls){this.ls=ls;}
    public void getLibraryForUser(Context ctx){
        ctx.status(200);
        ctx.json(ls.getLibraryById(Integer.parseInt(ctx.pathParam("userCode"))));
        //needs to either switch to get entries by ID or create new endpoint for user code
    }
}
