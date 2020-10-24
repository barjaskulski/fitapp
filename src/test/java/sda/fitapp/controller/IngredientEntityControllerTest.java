package sda.fitapp.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import sda.fitapp.repository.JpaIngredientRepository;
import sda.fitapp.service.IngredientService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@AutoConfigureMockMvc
class IngredientEntityControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private JpaIngredientRepository repository;

    @Test
    void shouldReturnAllIngredients() throws Exception {
        //given
        String s = new String(Files.readAllBytes(Paths.get("src/test/resources/request/saveingredient.json")));

        //when
        for (int i = 0; i < 5; i++) {
            mvc.perform(
                    post("/ingredient")
                            .header("content-type", "application/json")
                            .content(s))
                    .andExpect(status().isOk());
        }

        //then
        mvc.perform(get("/ingredient"))
                .andExpect(status().isOk());
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

    @Test
    @Sql(statements = {"DELETE FROM WRAPPER_INGREDIENT_TO_PROPORTION;"})
    void shouldRemoveIngredientFromDatabase() throws Exception {

        //given
        String s = new String(Files.readAllBytes(Paths.get("src/test/resources/request/saveingredient.json")));

        //when
        mvc.perform(
                post("/ingredient")
                        .header("content-type", "application/json")
                        .content(s))
                .andExpect(status().isOk());

        //then
        mvc.perform(
                delete("/ingredient/1")
                        .header("content-type", "application/json")
                        .content(s))
                .andExpect(status().isOk());

    }

}
