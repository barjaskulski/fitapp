package sda.fitapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import sda.fitapp.entity.UserEntity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserEntityControllerTest {


    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private UserService userService;

    @Test
    void getAllUsers() throws Exception {
        UserEntity userEntity1 = new UserEntity(1, "emailjakis", "jakieshaslo",
                "imie", "nazwisko", true);
        UserEntity userEntity2 = new UserEntity(2, "emailjakis", "jakieshaslo",
                "imie", "nazwisko", true);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
                //.andExpect(content().json("{\"userId\":1,\"userEmail\":\"jakis mail\",\"userPassword\":\"jakies haslo\",\"serviceRoles\":null,\"userName\":null,\"userSurname\":null,\"userSex\":null,\"userPhoneNumber\":null,\"userAge\":0,\"userHeight\":null,\"userWeight\":null,\"userCaloricDemand\":null,\"userCaloricDeficit\":null,\"lifeStyle\":null,\"userMealCount\":0}"));


    }

    @Test
    void getUserById() {
//        User user1 = new User(1,"emailjakis","jakieshaslo");
//        User user2 = new User(2,"emailjakis","jakieshaslo");
//        when(userService.getUserById(1)).thenReturn((user2));
    }

    @Test
    void addUser() throws Exception {
        String s ="{\n" +
                "        \"userEmail\": \"jakis mail\",\n" +
                "        \"userPassword\": \"jakies haslo\"\n" +
                "}";
        mockMvc.perform(
                post("/users")
                        .header("content-type", "application/json")
                        .content(s))
                .andExpect(status().isOk())
//        .andExpect(content().json("{\"userId\":1,\"userEmail\":\"jakis mail\",\"userPassword\":\"jakies haslo\",\"serviceRoles\":null,\"userName\":null,\"userSurname\":null,\"userSex\":null,\"userPhoneNumber\":null,\"userAge\":0,\"userHeight\":null,\"userWeight\":null,\"userCaloricDemand\":null,\"userCaloricDeficit\":null,\"lifeStyle\":null,\"userMealCount\":0}"));
        .andExpect(content().json("{}"));
    }

    @Test
    void removeUserById() {
    }
}