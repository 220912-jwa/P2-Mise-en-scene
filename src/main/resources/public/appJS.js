/*Mis En Scene JavaScript:*/

/*Every variable outside a function I'm using as a "global scope variable."*/

let baseURL = "http://localhost:8080";

function wrongPasswordAlert(){
    alert("Invalid Password");
}

function noUserFoundAlert(){
    confirm("Invalid Username. Would you like to create a new account?");
}

function noUserFoundAlertRedirect(){
    document.location.assign("./register.html");
}
async function loadLibrary(){
    let resBody = await fetch(`${baseURL}/${userID}/library`);
    if(resBody.status === 200){
        let library = await resBody.json();
        library.forEach(libraryEntry => {addMovieToTable(libraryEntry);
        });
    }
}
function addMovieToTable(libraryEntry){
    sessionStorage.setItem(`${libraryEntry.movieID}`,JSON.stringify(libraryEntry));
    thisEntry=libraryEntry.movieID;
    let table=document.getElementById("library");
    let newRow = document.createElement("tr");
    newRow.id=libraryEntry.movieID;
    let title = document.createElement("td");
    let releaseYear = document.createElement("td");
    let imdbRating = document.createElement("td");
    let watched = document.createElement("td");
    let favorite = document.createElement("td");
    let userRating = document.createElement("td");
    let userComments = document.createElement("td");
    let saveChanges = document.createElement("td");
    let deleteEntry = document.createElement("td");
    title.innerHTML=`<td style="width:15%">${libraryEntry.title}</td>`;//libraryEntry.title;
    releaseYear.innerHTML=libraryEntry.releaseYear;
    imdbRating.innerHTML=libraryEntry.rating;    
    if (libraryEntry.hasWatched){
        watched.innerHTML=`<input id="${thisEntry}_isWatched" type="checkbox" checked></input>`;}
        else{watched.innerHTML=`<input id="${thisEntry}_isWatched" type="checkbox"></input>`;}
    if (libraryEntry.isFavorite){
        favorite.innerHTML=`<input id="${thisEntry}_isFavorite" type="checkbox" checked></input>`;}
        else{favorite.innerHTML=`<input id="${thisEntry}_isFavorite" type="checkbox"></input>`;}
    userRating.innerHTML=`<input type="number" max="10" min="0" step="0.1" id="${thisEntry}_userRating" value="${libraryEntry.userRating}" ">/10</input>`;
    userComments.innerHTML=`<input type="text" id="${thisEntry}_userComments" value="${libraryEntry.userComments}" "></input>`;
    //all user inputs will need functions to edit, 
    
    saveChanges.innerHTML = `<button type="button" text="Save" onclick="updateMovie(thisEntry)">Save</button>`;
    deleteEntry.innerHTML = `<button type="button" text="Remove" onclick="deleteEntry(thisEntry)">Remove</button>`;
    newRow.append(title,releaseYear,imdbRating,watched,favorite,userRating,userComments,saveChanges,deleteEntry);
    table.append(newRow); 
}
function addMovie(){
    //collects info from movie fields on add.html and posts to server
}
async function deleteEntry(movieID){
    //currently, LibraryEntryDAO wants a whole object, not movieID
    let libraryEntryDelete = {
       
        userID: userID,
        movieID: movieID,
        userComments: document.getElementById(`${movieID}_userComments`).value,
        userRating: document.getElementById(`${movieID}_userRating`).value,
        isFavorite: favorited,
        hasWatched: watched
    }
    let libraryEntryJSON = JSON.stringify(libraryEntryDelete);
    console.log(libraryEntryJSON);

    let res = await fetch(`${baseURL}/${userID}/${movieID}`,
    {
        method: "DELETE",
        headers: {"Content-Type": "application/json"},
        body: libraryEntryJSON
    }
    );
}
async function updateMovie(movieID){
    if(document.getElementById(`${movieID}_isFavorite`).checked){
        favorited = 'true';
    }else{favorited = 'false'}
    if(document.getElementById(`${movieID}_isWatched`).checked){
        watched = 'true';
    }else{watched = 'false'}
    let libraryEntryUpdate = {
       
        userID: userID,
        movieID: movieID,
        userComments: document.getElementById(`${movieID}_userComments`).value,
        userRating: document.getElementById(`${movieID}_userRating`).value,
        isFavorite: favorited,
        hasWatched: watched
    }
    let libraryEntryJSON = JSON.stringify(libraryEntryUpdate);
    console.log(libraryEntryJSON);

    let res = await fetch(`${baseURL}/${userID}/library`,
    {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: libraryEntryJSON
    }
    );
    if (res.status === 204) {
        let resBody = await res.json();
        console.log(resBody);
        alert("Movie Status Updated Successfully!");}
}


async function userLogin(){

    uName = document.getElementById('userName').value;
    uPass = document.getElementById('userPass').value;

    let credentials = {
        username: uName,
        pass: uPass
    }

    credentialsJSON = JSON.stringify(credentials);
        let resBody = await fetch(
        `${baseURL}/authenticate`,
        {
            method: 'POST',
            header: {'Content-Type': 'application/json'},
            body: credentialsJSON
        }
    );

    if (resBody.status===200){
        let loggedInUser = await resBody.json();
        sessionStorage.setItem('userName', loggedInUser.username);
        sessionStorage.setItem("userID",loggedInUser.userID);
        document.location.assign("./library.html");
    }
}

let name = sessionStorage.getItem("userName");
let userID = sessionStorage.getItem("userID");

