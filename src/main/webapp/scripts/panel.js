import { displayQuestionnairePage } from "./questionnaire.js";
import { displayReportPage } from "./report.js";
import { displayDietPage } from "./diet.js";
import { displayTrainingPage } from "./training.js";
import { displayResultPage } from "./result.js";

import { sendRequest } from "./request.js";

export function displayPanel() {
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
                    <button type="button" id="training_button" class="btn btn-secondary" btn-lg">Trening/aktywność</button>
                    <button type="button" id="results_button" class="btn btn-secondary" btn-lg">Podsumowanie wyników</button>
                </div>
            </div>
            <div class="col">
                <p id="page_content"></p>
            </div>
        </div>
    `;

    document.getElementById("root").innerHTML = pageContent;

    document.getElementById("report_button").onclick = displayReportPage;
    document.getElementById("diet_button").onclick = displayDietPage;
    document.getElementById("training_button").onclick = displayTrainingPage;
    document.getElementById("results_button").onclick = displayResultPage;

    sendRequest("GET", "/users/current_user", null, null, getUsernameCallback);
}

function getUsernameCallback() {
    let body = JSON.parse(this.responseText);

    document.getElementById("name").innerHTML = body.firstName + " " + body.lastName;

    if(body.showQuestionnaire) {
        document.getElementById("questionnaire").innerHTML = 
            `<button type="button" id="questionnaire_button" class="btn btn-primary" btn-lg">Pierwsza ankieta</button>`;
        document.getElementById("questionnaire_button").onclick = displayQuestionnairePage;
    }
}
