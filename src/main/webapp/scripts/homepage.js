export function dispalyHomePage() {

    let pageContent = `
        <h3>
            Hello this is Fitapp application!
        </h3>
        <h3 id="name"></h3>
        <button type="button" class="btn btn-outline-primary btn-lg">Raport</button></br>
        <button type="button" class="btn btn-outline-primary btn-lg">Twoja dieta</button></br>
        <button type="button" class="btn btn-outline-primary btn-lg">Trening/aktywność</button></br>
        <button type="button" class="btn btn-outline-primary btn-lg">Podsumowanie wyników</button></br>

    `;

    document.getElementById("root").innerHTML = pageContent;

    getUsername();
}

function getUsername() {
    let req = new XMLHttpRequest();
    req.addEventListener("load", () => {
        let body = JSON.parse(req.responseText);

        document.getElementById("name").innerHTML = body.firstName + " " + body.lastName;
    });
    req.open("GET", "/users", true);
    req.send();
}
