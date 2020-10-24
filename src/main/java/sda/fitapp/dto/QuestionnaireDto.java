package sda.fitapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionnaireDto {
    private String contactHours;
    private String age;
    private String weight;
    private String height;
    private String goal;
    private String previousAttempts;
    private String healthCondition;
    private String injuries;
    private String medicines;
    private String bloodTests;
    private String dayDescription;
    private String wellBeing;
    private String dietType;
    private String dietExclusions;
    private String proteinSupplement;
    private String treningDescription;
    private String cooperationPeriod;
    private String additionalInfo;
}
