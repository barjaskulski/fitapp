export function dispalyHomePage() {

    let pageContent = `
        <h3>
            Hello this is Fitapp application!
        </h3>
        <h3 id="name"></h3>

    `;

    document.getElementById("root").innerHTML = pageContent;
}
