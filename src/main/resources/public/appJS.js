/*Mis En Scene JavaScript:*/

/*Every variable outside a function I'm using as a "global scope variable."*/

let baseURL = "http://localhost:8080";

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

    if (res.status===200){
        let loggedInUser = await resBody.json();
        sessionStorage.setItem('userName', loggedInUser.username);
        document.location.assign("./library.html");
    }

}

let name = sessionStorage.getItem("userName");



