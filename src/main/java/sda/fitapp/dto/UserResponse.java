package sda.fitapp.dto;

import lombok.Getter;
import sda.fitapp.entity.UserEntity;

@Getter
public class UserResponse {
    private String firstName;
    private String lastName;
    private long age;
    private Double height;
    private double weight;
    private double lifestyle;
    private Double userCaloricDeficit;
    private long caloricDemandForReduction;
    private long userDemandForProteins;
    private long userDemandForCarbs;
    private long userDemandForFats;
    private long breakfastKcal;
    private long breakfastProteins;
    private long breakfastCarbs;
    private long breakfastFats;
    private long secondBreakfastKcal;
    private long secondBreakfastProteins;
    private long secondBreakfastCarbs;
    private long secondBreakfastFats;
    private long dinnerKcal;
    private long dinnerProteins;
    private long dinnerCarbs;
    private long dinnerFats;
    private long supperKcal;
    private long supperProteins;
    private long supperCarbs;
    private long supperFats;


    public UserResponse(UserEntity userEntity) {
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.age = userEntity.getUserAge();
        this.height = userEntity.getUserHeight();
        this.weight = userEntity.getUserWeight();
        this.lifestyle = userEntity.getLifeStyle().getNumVal();
        this.userCaloricDeficit = userEntity.getUserCaloricDeficit();
        this.caloricDemandForReduction = (long) ((((((9.99 * weight) + (6.25 * height) + (4.92 * age)) + userEntity.getUserSex().getNumVal()) * lifestyle)) - userCaloricDeficit);
        this.userDemandForProteins = (long) weight * 2;
        this.userDemandForFats = Math.round(weight * 0.9);
        this.userDemandForCarbs = (((caloricDemandForReduction) - (userDemandForProteins * 4) - (userDemandForFats * 9)) / 4);
        this.breakfastProteins = Math.round(userDemandForProteins * 0.25);
        this.breakfastCarbs = Math.round(userDemandForCarbs * 0.25);
        this.breakfastFats = Math.round(userDemandForFats * 0.25);
        this.breakfastKcal = breakfastProteins * 4 + breakfastCarbs * 4 + breakfastFats * 9;
        this.secondBreakfastProteins = Math.round(userDemandForProteins * 0.20);
        this.secondBreakfastCarbs = Math.round(userDemandForCarbs * 0.20);
        this.secondBreakfastFats = Math.round(userDemandForFats * 0.20);
        this.secondBreakfastKcal = secondBreakfastProteins * 4 + secondBreakfastCarbs * 4 + secondBreakfastFats * 9;
        this.dinnerProteins = Math.round(userDemandForProteins * 0.30);
        this.dinnerCarbs = Math.round(userDemandForCarbs * 0.30);
        this.dinnerFats = Math.round(userDemandForFats * 0.30);
        this.dinnerKcal = dinnerProteins * 4 + dinnerCarbs * 4 + dinnerFats * 9;
        this.supperProteins = Math.round(userDemandForProteins * 0.25);
        this.supperCarbs = Math.round(userDemandForCarbs * 0.25);
        this.supperFats = Math.round(userDemandForFats * 0.25);
        this.supperKcal = supperProteins * 4 + supperCarbs * 4 + supperFats * 9;
    }
}




