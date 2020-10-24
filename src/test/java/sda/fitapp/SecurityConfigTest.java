package sda.fitapp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static javax.swing.UIManager.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mvc;

//    @Test
//    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
//    public void configure() throws Exception {
//        this.mvc.perform(get("/users"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
}