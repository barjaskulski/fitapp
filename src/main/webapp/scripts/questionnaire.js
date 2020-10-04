import { sendRequest } from "./request.js";

export function dispalyQuestionnairePage() {
    let pageContent = `
        <h3>Ankieta</h3> </br>
        Preferowane godziny kontaktu: <input type="text" class="form-control" id="contact_hours"><br/>
        Podaj swój wiek: <input type="text" class="form-control" id="age"><br/>
        Podaj swoją wagę: <input type="text" class="form-control" id="weight"><br/>
        Podaj swój wzrost: <input type="text" class="form-control" id="height"><br/>
        Jaki jest Twój cel?(jeśli jest to cel wagowy, proszę podać ilość): <input type="text" class="form-control" id="goal"><br/>
        Czy próbowałaś/eś już go zrealizować? Jeśli tak to opisz wszystko dokładnie: <input type="text" class="form-control" id="previous_attempts"><br/>
        Czy masz jakieś problemy zdrowotne? Cukrzyca, niedoczynność tarczycy, nadciśnienie, itp: <input type="text" class="form-control" id="health_condition"><br/>
        Czy masz jakieś kontuzje: <input type="text" class="form-control" id="injuries"><br/>
        Czy zażywasz jakieś leki: <input type="text" class="form-control" id="medicines"><br/>
        Kiedy ostatnio wykonywałeś/aś kompleksowe badania krwi? Jeśli masz wyniki, to prześlij je w załączniku: <input type="text" class="form-control" id="blood_tests"><br/>
        Jak wygląda Twój przykładowy dzień? O której wstajesz? co najcześciej jesz i w jakich ilościach, jaką pracę wykonujesz? Siedząca, fizyczna? Jeśli trenujesz, to jakie to są treningi? W jakich godzinach i w jakich dniach: <input type="text" class="form-control" id="day_description"><br/>
        Jak oceniasz swoje samopoczucie? Czy się wysypiasz? Czy masz energię w ciągu dnia: <input type="text" class="form-control" id="wellbeing"><br/>
        Czy stosujesz jakąś dietę? Wegetariańska, bez glutenu, bez laktozy, itp: <input type="text" class="form-control" id="diet_type"><br/>
        Jakich produktów spożywczych nie chcesz mieć w swojej diecie? (jadłospis będzie układany na podstawie tego pola, proszę dokładnie wszystko wypisać): <input type="text" class="form-control" id="diet_exclusions"><br/>
        Czy chcesz, aby w Twojej diecie była uwzględniona odżywka białkowa: <input type="text" class="form-control" id="protein_supplement"><br/>
        Ile razy w tygodniu możesz trenować i jakie treningi chcesz wykonywać? Trening siłowy, fitness, rower, trening w domu, spacery, pracuje fizycznie-nie trenuje: <input type="text" class="form-control" id="trening_description"><br/>
        Na jak długo chcesz nawiązać współpracę: <input type="text" class="form-control" id="cooperation_period"><br/>
        Jeśli uważasz, że jest jeszcze coś o czym powinienem wiedzieć, to tutaj możesz to opisać: <input type="text" class="form-control" id="additional_info"><br/>
        <button type="button" id="submit_questionnaire_button" class="btn btn-primary" btn-lg">Wyślij ankietę</button>
    `;

    document.getElementById("page_content").innerHTML = pageContent;

    document.getElementById("submit_questionnaire_button").onclick = 
        () => {
            sendRequest(
                "POST", 
                "/questionnaire",
                JSON.stringify(
                    {
                        contactHours: document.getElementById("contact_hours").value,
                        age: document.getElementById("age").value,
                        weight: document.getElementById("weight").value,
                        height: document.getElementById("height").value,
                        goal: document.getElementById("goal").value,
                        previousAttempts: document.getElementById("previous_attempts").value,
                        healthCondition: document.getElementById("health_condition").value,
                        injuries: document.getElementById("injuries").value,
                        medicines: document.getElementById("medicines").value,
                        bloodTests: document.getElementById("blood_tests").value,
                        dayDescription: document.getElementById("day_description").value,
                        wellbeing: document.getElementById("wellbeing").value,
                        dietType: document.getElementById("diet_type").value,
                        dietExclusions: document.getElementById("diet_exclusions").value,
                        proteinSupplement: document.getElementById("protein_supplement").value,
                        treningDescription: document.getElementById("trening_description").value,
                        cooperationPeriod: document.getElementById("cooperation_period").value,
                        additionalInfo: document.getElementById("additional_info").value
                    }
                ),
                "application/json",
                function() { console.log("questionnaire sent!") }
            );
        };
}