package sda.fitapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import sda.fitapp.entity.Ingredient;
import sda.fitapp.repository.JpaIngredientRepository;
import sda.fitapp.service.IngredientService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class IngredientControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private JpaIngredientRepository repository;


    @Test
    void shouldReturnAllIngredients() throws Exception {
        //given
        List<Ingredient> expectedIngredientList = new ArrayList(Arrays.asList(
                new Ingredient(1, "test", 100, 100, 100, 100, true, true, true),
                new Ingredient(2, "test", 100, 100, 100, 100, true, true, true),
                new Ingredient(3, "test", 100, 100, 100, 100, true, true, true),
                new Ingredient(4, "test", 100, 100, 100, 100, true, true, true),
                new Ingredient(5, "test", 100, 100, 100, 100, true, true, true)
        ));
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(expectedIngredientList);
        String s = new String(Files.readAllBytes(Paths.get("src/test/resources/request/saveingredient.json")));

        //when
        for (int i = 0; i < 5; i++) {
            mvc.perform(
                    post("/ingredient")
                            .header("content-type", "application/json")
                            .content(s));
        }

        //then
        mvc.perform(get("/ingredient"))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResult));

    }

    @Test
    void shouldReturnOneIngredientWithIndicatedId() throws Exception {

        //given
        String s = new String(Files.readAllBytes(Paths.get("src/test/resources/request/saveingredientwithid.json")));

        //when
        mvc.perform(
                post("/ingredient")
                        .header("content-type", "application/json")
                        .content(s))
                .andExpect(status().isOk());

        //then
        mvc.perform(
                get("/ingredient/1")
                        .header("content-type", "application/json")
                        .content(s))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':1}"));
    }

}
