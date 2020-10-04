package sda.fitapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.fitapp.dto.UserResponse;

@RestController
public class FitappController {

    @GetMapping("/users")
    public UserResponse getUser() {
        return UserResponse.builder()
                .firstName("fname")
                .lastName("lname")
                .email("email@pl")
                .phoneNumber("121 121")
                .age(22)
                .height(184)
                .weight(55)
                .lifestyle(5)
                .caloricDemand(2500)
                .numberOfMeals(3)
                .showQuestionnaire(true)
                .build();
    }
}
