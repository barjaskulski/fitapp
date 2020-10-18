import { sendRequest } from "./request.js";

export function displayDietPage() {
    let pageContent = `
        
        <h2>Twoja dieta</h2>

        <div class="row">
            <div class="col">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdown_breakfast" 
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dodaj śniadanie
                    </button>
                    <div class="dropdown-menu" id="breakfast_list" aria-labelledby="dropdown_breakfast">
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdown_lunch" 
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dodaj obiad
                    </button>
                    <div class="dropdown-menu" id="lunch_list" aria-labelledby="dropdown_lunch">
                        <button class="dropdown-item" type="button" id="breakfast_1">Śniadanie 1</button>
                        <button class="dropdown-item" type="button" id="breakfast_1">Śniadanie 2</button>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdown_second_breakfast" 
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dodaj drugie śniadanie
                    </button>
                    <div class="dropdown-menu" id="second_breakfast_list" aria-labelledby="dropdown_second_breakfast">
                        <button class="dropdown-item" type="button" id="breakfast_1">Śniadanie 1</button>
                        <button class="dropdown-item" type="button" id="breakfast_1">Śniadanie 2</button>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdown_dinner" 
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dodaj kolację
                    </button>
                    <div class="dropdown-menu" id="dinner_list" aria-labelledby="dropdown_dinner">
                        <button class="dropdown-item" type="button" id="breakfast_1">Śniadanie 1</button>
                        <button class="dropdown-item" type="button" id="breakfast_1">Śniadanie 2</button>
                    </div>
                </div>
            </div>
        </div>
        </br>

        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Podsumowanie</h5>
                <p class="card-text">
                    Kalorie: 0/2000 kcal <br/>
                    Białko: 0/160 g <br/>
                    Węglowodany: 0/200 g <br/>
                    Tłuszcze: 0/90 g <br/>
                </p>
            </div>
        </div>

    `;

    document.getElementById("page_content").innerHTML = pageContent;

    sendRequest("GET", "/api/meal/breakfast", null, null, getBreakfastCallback);
    sendRequest("GET", "/api/meal/second_breakfast", null, null, getSecondBreakfastCallback);
    sendRequest("GET", "/api/meal/dinner", null, null, getLunchCallback);
    sendRequest("GET", "/api/meal/supper", null, null, getDinnerCallback);
}

function getBreakfastCallback() {
    let body = JSON.parse(this.responseText);
    
    let list = [];
    body.forEach(element => 
        list.push(`<button class="dropdown-item" type="button" id="breakfast_${element.id}">${element.name}</button>`)
    );

    document.getElementById("breakfast_list").innerHTML = list;
}

function getSecondBreakfastCallback() {
    let body = JSON.parse(this.responseText);

    let list = [];
    body.forEach(element => 
        list.push(`<button class="dropdown-item" type="button" id="second_breakfast_${element.id}">${element.name}</button>`)
    );
    document.getElementById("second_breakfast_list").innerHTML = list;
}

function getLunchCallback() {
    let body = JSON.parse(this.responseText);

    let list = [];
    body.forEach(element => 
        list.push(`<button class="dropdown-item" type="button" id="lunch_${element.id}">${element.name}</button>`)
    );
    document.getElementById("lunch_list").innerHTML = list;
}

function getDinnerCallback() {
    let body = JSON.parse(this.responseText);

    let list = [];
    body.forEach(element => 
        list.push(`<button class="dropdown-item" type="button" id="dinner_${element.id}">${element.name}</button>`)
    );
    document.getElementById("dinner_list").innerHTML = list;
}
