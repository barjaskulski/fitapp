package sda.fitapp.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sda.fitapp.ENUM.LifeStyle;
import sda.fitapp.ENUM.ServiceRoles;
import sda.fitapp.entity.UserEntity;
import sda.fitapp.ENUM.UserSex;

class UserEntityResponseTest {

    UserEntity userEntity = new UserEntity(1, "gmail", "1234", ServiceRoles.SUBSCRIBED_USER, "Łukasz", "Kozłowski", UserSex.MALE, "123456", 20, 180, 80.0, 1245, LifeStyle.MIDDLE);

    @Test
    public void shouldCountUserCaloricDemandForReduction() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(2000, userResponse.getCaloricDemandForReduction());
    }

    @Test
    public void shouldCountUserDemandForProteins() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(160, userResponse.getUserDemandForProteins());
    }

    @Test
    public void shouldCountUserDemandForCarbs() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(178, userResponse.getUserDemandForCarbs());
    }

    @Test
    public void shouldCountUserDemandForFats() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(72, userResponse.getUserDemandForFats());
    }

    @Test
    public void shouldCountBreakfastProteins() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(40,userResponse.getBreakfastProteins());
    }

    @Test
    public void shouldCountBreakfastCarbs() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(45,userResponse.getBreakfastCarbs());
    }

    @Test
    public void shouldCountBreakfastFats() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(18,userResponse.getBreakfastFats());
    }

    @Test
    public void shouldCountBreakfastKcal() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(502,userResponse.getBreakfastKcal());
    }

    @Test
    public void shouldCountSecondBreakfastProteins() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(32, userResponse.getSecondBreakfastProteins());
    }

    @Test
    public void shouldCountSecondBreakfastCarbs() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(36,userResponse.getSecondBreakfastCarbs());
    }

    @Test
    public void shouldCountSecondBreakfastFats() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(14,userResponse.getSecondBreakfastFats());
    }

    @Test
    public void shouldCountSecondBreakfastKcal() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(398,userResponse.getSecondBreakfastKcal());
    }

    @Test
    public void shouldCountDinnerProteins() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(48,userResponse.getDinnerProteins());
    }

    @Test
    public void shouldCountDinnerCarbs() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(53,userResponse.getDinnerCarbs());
    }

    @Test
    public void shouldCountDinnerFats() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(22,userResponse.getDinnerFats());
    }

    @Test
    public void shouldCountDinnerKcal() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(602,userResponse.getDinnerKcal());
    }

    @Test
    public void shouldCountSupperProteins() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(40,userResponse.getSupperProteins());
    }

    @Test
    public void shouldCountSupperCarbs() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(45, userResponse.getSupperCarbs());
    }

    @Test
    public void shouldCountSupperFats() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(18, userResponse.getSupperFats());
    }

    @Test
    public void shouldCountSupperKcal() {
        UserResponse userResponse = new UserResponse(userEntity);
        Assertions.assertEquals(502, userResponse.getSupperKcal());
    }
}