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
    let table=document.getElementById("library");
    let newRow = document.createElement("tr");
    newRow.id=movie.movieID;
    let title = document.createElement("td");
    let releaseYear = document.createElement("td");
    let watched = document.createElement("td");
    let favorite = document.createElement("td");
    let userRating = document.createElement("td");
    let userComments = document.createElement("td");
    let saveChanges = document.createElement("td");
    title.innerHTML=libraryEntry.title;
    releaseYear.innerHTML=libraryEntry.releaseYear;
    watched.innerHTML=`<input id=""type="checkbox" checked="${libraryEntry.hasWatched}"></input>`;
    favorite.innerHTML=libraryEntry.isFavorite;
    userRating.innerHTML=libraryEntry.userRating;
    userComments.innerHTML=libraryEntry.userComments;
    //userComments.innerHTML=`${libraryEntry.userComments}<br><button type="button" onclick="editComments(thisEntry)">Edit</button>`;
    //all user inputs will need functions to edit, 
    thisEntry=libraryEntry.movieID;
    saveChanges.innerHTML = `<button type="button" text="Save" onclick="updateMovie(thisEntry)">Save</button>`;
    newRow.append(title,releaseYear,watched,favorite,userRating,userComments,saveChanges);
    table.append(newRow); 
}
function addMovie(){
    //collects info from movie fields on add.html and posts to server
}
function updateMovie(movieID){
    //should read current movie info from session storage w/ name movieID, then put requests server
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

