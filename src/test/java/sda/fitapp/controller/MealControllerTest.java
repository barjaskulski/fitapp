package sda.fitapp.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sda.fitapp.entity.Meal;
import sda.fitapp.repositories.MealRepositories;
import sda.fitapp.services.MealService;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        String s =new String(Files.readAllBytes(Paths.get("src/test/resources/request/savemeal.json")));
        mvc.perform(
                post("/api/meal")
                        .header("content-type", "application/json")
                        .content(s))
        .andExpect(status().isOk())
        .andExpect(content().json("{'id': 1}"));

//        ArgumentCaptor<Meal> argumentCaptor = ArgumentCaptor.forClass(Meal.class);
////        Mockito.verify(mealRepositories).save(argumentCaptor.capture());
//        assertEquals("wiadro",argumentCaptor.getValue().getName());

    }


}