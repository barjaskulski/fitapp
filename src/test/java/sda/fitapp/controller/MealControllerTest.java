package sda.fitapp.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Meal Controller Test")
class MealControllerTest {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setUp() throws Exception {

        String ingredientString = new String(Files.readAllBytes(Paths.get("src/test/resources/request/saveingredient.json")));

        mvc.perform(
                post("/ingredient")
                        .header("content-type", "application/json")
                        .content(ingredientString));
        mvc.perform(
                post("/ingredient")
                        .header("content-type", "application/json")
                        .content(ingredientString));

    }

    @Test
    void addMealTest() throws Exception {

        String mealString = new String(Files.readAllBytes(Paths.get("src/test/resources/request/savemeal.json")));
        mvc.perform(
                post("/api/meal")
                        .header("content-type", "application/json")
                        .content(mealString))
                .andExpect(status().isOk())
                .andExpect(content().json("{'name': 'wiadro'}"));
    }

    @Test
    void getMealTest() throws Exception {
        String mealString = new String(Files.readAllBytes(Paths.get("src/test/resources/request/savemeal.json")));
        mvc.perform(
                post("/api/meal")
                        .header("content-type", "application/json")
                        .content(mealString));
        mvc.perform(
                get("/api/meal"))
                .andExpect(status().isOk())
//                .andExpect(content().json("[{'name': 'wiadro'}]"))
        ;

    }


}