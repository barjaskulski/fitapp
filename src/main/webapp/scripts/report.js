export function displayReportPage() {
    let pageContent = `
        <img src="../images/sylwetka_raport.png" width="595" height="507">

        <h3>Ankieta</h3> </br>
        Data pomiaru: <input type="text" class="form-control" id="measurment_date"><br/>
        Godzina pomiaru: <input type="text" class="form-control" id="measurment_time"><br/>
        Waga w kg: <input type="text" class="form-control" id="weight"><br/>
        Obwód klatki piersiowej w cm: <input type="text" class="form-control" id="chest_circumference"><br/>
        Obwód ramienia w cm: <input type="text" class="form-control" id="arm_circumference"><br/>
        Obwód talii w cm: <input type="text" class="form-control" id="waist_circumference"><br/>
        Obwód brzucha w cm: <input type="text" class="form-control" id="abdominal_circumference"><br/>
        Obwód biodra w cm: <input type="text" class="form-control" id="hip_circumference"><br/>
        Obwód uda w cm: <input type="text" class="form-control" id="thigh_circumference"><br/>
        Zdjęcia przód, bok, tył: <input type="text" class="form-control" id="photos"><br/>
        Ilość wykonanych treningów (czy były jakieś odstępstwa od planu treningowego, jeśli tak, to jakie?): <input type="text" class="form-control" id="trainings_description"><br/>
        Czy były jakieś odstępstwa od diety? Jeśli tak to jakie?: <input type="text" class="form-control" id="training_exemption"><br/>
        Czy były jakieś odstępstwa od suplementacji? Jeśli tak to jakie?: <input type="text" class="form-control" id="supplementation_exemption"><br/>
        Samopoczucie w ciągu dnia: <input type="text" class="form-control" id="wellbeing"><br/>
        Energia na treningu: <input type="text" class="form-control" id="energy"><br/>
        Regeneracja po treningu: <input type="text" class="form-control" id="regeneration"><br/>
        Czy występowały problemy ze snem?: <input type="text" class="form-control" id="sleeping_problems"><br/>
        Czy byłeś/aś narażony/a na większy stres?: <input type="text" class="form-control" id="stress_exposition"><br/>
        Czy wystąpiła jakaś choroba?: <input type="text" class="form-control" id="infection"><br/>
        Czy wystąpiły problemy z wypróżnianiem?: <input type="text" class="form-control" id="defecation"><br/>
        Czy pomiary zostały wykonane na 7 dni przed okresem lub w trakcie okresu?(pytanie wyświetla się jeśli jest kobietą): <input type="text" class="form-control" id="period"><br/>
        Dodatkowe informacje. Ewentualne zmiany w jadłospisie: <input type="text" class="form-control" id="additional_info"><br/>
        <button type="button" id="submit_report_button" class="btn btn-primary" btn-lg">Wyślij raport</button>

    `;


    document.getElementById("page_content").innerHTML = pageContent;
}