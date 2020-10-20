import { sendRequest } from "./request.js";

var actualCalories = "0";
var actualProtein = "0";
var actualCarbon = "0";
var actualFat = "0";

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
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdown_dinner" 
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dodaj kolację
                    </button>
                    <div class="dropdown-menu" id="dinner_list" aria-labelledby="dropdown_dinner">
                    </div>
                </div>
            </div>
        </div>
        </br>

        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Podsumowanie</h5>
                <p class="card-text">
                    Kalorie: <span id="actual_calories"></span>/<span id="caloric_demand"></span> kcal <br/>
                    Białko: <span id="actual_protein"></span>/<span id="protein_demand"></span> g <br/>
                    Węglowodany: <span id="actual_carbon"></span>/<span id="carbon_demand"></span> g <br/>
                    Tłuszcze: <span id="actual_fat"></span>/<span id="fat_demand"></span> g <br/>
                </p>
            </div>
        </div>

    `;

    document.getElementById("page_content").innerHTML = pageContent;

    sendRequest("GET", "/api/meal/breakfast", null, null, getBreakfastCallback);
    sendRequest("GET", "/api/meal/second_breakfast", null, null, getSecondBreakfastCallback);
    sendRequest("GET", "/api/meal/dinner", null, null, getLunchCallback);
    sendRequest("GET", "/api/meal/supper", null, null, getDinnerCallback);

    sendRequest("GET", "/api/meal/summary", null, null, getDietSummaryCallback);

    setDietSummaryValues();

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

function getDietSummaryCallback() {
    let body = JSON.parse(this.responseText);

    if(body.caloricDemand != null) {
        document.getElementById("caloric_demand").innerHTML = body.caloricDemand;
    }

    if(body.proteinDemand != null) {
        document.getElementById("protein_demand").innerHTML = body.proteinDemand;
    }

    if(body.carbonDemand != null) {
        document.getElementById("carbon_demand").innerHTML = body.carbonDemand;
    }

    if(body.fatDemand != null) {
        document.getElementById("fat_demand").innerHTML = body.fatDemand;
    }
    
}

function setDietSummaryValues() {

    document.getElementById("actual_calories").innerHTML = actualCalories;
    document.getElementById("actual_protein").innerHTML = actualProtein;
    document.getElementById("actual_carbon").innerHTML = actualCarbon;
    document.getElementById("actual_fat").innerHTML = actualFat;

}
