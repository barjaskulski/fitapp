package sda.fitapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import sda.fitapp.entity.TagEntity;
import sda.fitapp.ENUM.TagsType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TagEntityControllerTest {

    @Autowired
    private MockMvc mvc;


    @BeforeEach
    void setUp() {

    }

    @Test
    void addTag() throws Exception {
        String tagString = new String(Files.readAllBytes(Paths.get("src/test/resources/request/savetag.json")));
        mvc.perform(
                post("/api/tag")
                        .header("content-type", "application/json")
                        .content(tagString))
                .andExpect(status().isOk())
                .andExpect(content().json("{'name': 'wiadro'}"));

    }

    @Test
    void getAllTags() throws Exception {
        //given
        List<TagEntity> expectedTagEntityList = new ArrayList(Arrays.asList(
                new TagEntity(1, "wiadro", TagsType.MEAL),
                new TagEntity(2, "wiadro", TagsType.MEAL)
        ));
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(expectedTagEntityList);
        String s = new String(Files.readAllBytes(Paths.get("src/test/resources/request/savetag.json")));

        //when
        for (int i = 0; i < 2; i++) {
            mvc.perform(
                    post("/api/tag")
                            .header("content-type", "application/json")
                            .content(s));
        }

        //then
        mvc.perform(get("/api/tag"))
                .andExpect(status().isOk());
    }

    @Test
    void getTagById() throws Exception {
        //given
        String s = new String(Files.readAllBytes(Paths.get("src/test/resources/request/savetag.json")));

        //when
        for (int i = 0; i < 5; i++) {
            mvc.perform(
                    post("/api/tag")
                            .header("content-type", "application/json")
                            .content(s));
        }
        //then
        mvc.perform(get("/api/tag/id/4"))
                .andExpect(status().isOk())
                .andExpect(content().json(s));

    }

    @Test
    void getTagByName() throws Exception {

        //given
        String s = new String(Files.readAllBytes(Paths.get("src/test/resources/request/savetag.json")));

        //when
        for (int i = 0; i < 5; i++) {
            mvc.perform(
                    post("/api/tag")
                            .header("content-type", "application/json")
                            .content(s));
        }
        //then
        mvc.perform(get("/api/tag/name/wiadro"))
                .andExpect(status().isOk())
                .andExpect(content().json(s));

    }

}
