package sda.fitapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sda.fitapp.dto.*;

@Slf4j
@RestController
public class FitappController {

    @GetMapping("/users")
    public UserResponse getUser() {
        return new UserResponse(
                "fname",
                "lname",
                "email@pl",
                "121 121",
                22,
                184,
                55,
                5,
                2500,
                3,
                true
        );
    }

    @PostMapping("/questionnaire")
    public void addQuestionnaire(@RequestBody QuestionnaireDto questionnaire) {
        log.info("questionnaire: {}", questionnaire.getAge());
    }
}
