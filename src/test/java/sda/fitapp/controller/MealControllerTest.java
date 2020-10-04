package sda.fitapp.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Meal Controller Test")
class MealControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void addMeal() throws Exception {

        String s = new String(Files.readAllBytes(Paths.get("src/test/resources/request/savemeal.json")));
        mvc.perform(
                post("/api/meal")
                        .header("content-type", "application/json")
                        .content(s))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1}"));


    }


}