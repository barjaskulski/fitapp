import { dispalyQuestionnairePage } from "./questionnaire.js";
import { dispalyReportPage } from "./report.js";
import { dispalyDietPage } from "./diet.js";
import { dispalyTreningPage } from "./trening.js";
import { dispalyResultPage } from "./result.js";

export function dispalyHomePage() {

    let pageContent = `
        <h3>
            Hello this is Fitapp application!
        </h3>
        <h3 id="name"></h3>
        <div class="row">
            <div class="col">
                <p id="questionnaire"></p>
                <div class="btn-group-vertical" role="group" aria-label="Basic example">
                    <button type="button" id="report_button" class="btn btn-secondary" btn-lg">Raport</button>
                    <button type="button" id="diet_button" class="btn btn-secondary" btn-lg">Twoja dieta</button>
                    <button type="button" id="trening_button" class="btn btn-secondary" btn-lg">Trening/aktywność</button>
                    <button type="button" id="results_button" class="btn btn-secondary" btn-lg">Podsumowanie wyników</button>
                </div>
            </div>
            <div class="col">
                <p id="page_content"></p>
            </div>
        </div>
    `;

    document.getElementById("root").innerHTML = pageContent;

    getUsername();

    document.getElementById("report_button").onclick = dispalyReportPage;
    document.getElementById("diet_button").onclick = dispalyDietPage;
    document.getElementById("trening_button").onclick = dispalyTreningPage;
    document.getElementById("results_button").onclick = dispalyResultPage;
}

function getUsername() {
    let req = new XMLHttpRequest();
    req.addEventListener("load", () => {
        let body = JSON.parse(req.responseText);

        document.getElementById("name").innerHTML = body.firstName + " " + body.lastName;

        if(body.showQuestionnaire) {
            document.getElementById("questionnaire").innerHTML = 
                `<button type="button" id="questionnaire_button" class="btn btn-primary" btn-lg">Pierwsza ankieta</button>`;
            document.getElementById("questionnaire_button").onclick = dispalyQuestionnairePage;
        }
    });
    req.open("GET", "/users", true);
    req.send();
}
