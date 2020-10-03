import { dispalyHomePage } from "./homepage.js";

window.onload = function() {
    dispalyHomePage();
    getUsername();

}

function getUsername() {
    let req = new XMLHttpRequest();
    req.addEventListener("load", () => {
        let body = JSON.parse(this.resonseText);
        state.firstName = body.firstName;
        state.lastName = body.lastName;

        document.getElementById("name").innerHTML = body.firstName + " " + body.lastName;
    });
    req.open("GET", "/userinfo", true);
    req.send();
}