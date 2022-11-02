package dev.mis.controllers;

import dev.mis.entities.LibraryEntry;
import dev.mis.entities.Movie;
import dev.mis.services.LibraryEntryService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class LibraryEntryController {
    private LibraryEntryService ls;
    public LibraryEntryController(LibraryEntryService ls){this.ls=ls;}
    public void createLibraryEntry(Context ctx){
        LibraryEntry libraryEntry = ctx.bodyAsClass(LibraryEntry.class);
        LibraryEntry newEntry = ls.createLibraryEntry(libraryEntry);
        ctx.status(HttpCode.CREATED);
    }
    public void getLibraryForUser(Context ctx){
        int userID = Integer.parseInt(ctx.pathParam("user_id"));
        ctx.status(200);
        ctx.json(ls.getUserEntriesById(userID));
    }
    public void getLibraryForCode(Context ctx){
        String userCode = ctx.pathParam("user_code");
        ctx.status(200);
        ctx.json(ls.getUserEntriesByCode(userCode));
    }
    public void deleteLibraryEntry(Context ctx){
        LibraryEntry entry = ctx.bodyAsClass(LibraryEntry.class);
        ls.deleteLibraryEntry(entry);
        ctx.status(HttpCode.NO_CONTENT);
    }
    public void updateLibraryEntry(Context ctx){
        LibraryEntry libraryEntry = ctx.bodyAsClass(LibraryEntry.class);
        ls.editLibraryEntry(libraryEntry);
        ctx.status(HttpCode.NO_CONTENT);
    }

}
