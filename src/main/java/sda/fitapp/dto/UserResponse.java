package sda.fitapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int age;
    private int height;
    private int weight;
    private int lifestyle;
    private int caloricDemand;
    private int numberOfMeals;
    private boolean showQuestionnaire;
}
