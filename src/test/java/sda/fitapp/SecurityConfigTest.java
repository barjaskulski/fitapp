package sda.fitapp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(username = "user", password = "user", roles = "USER")
    public void configure0() throws Exception {         // ----------- access only for ALL
        this.mvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "ADMIN")
    public void configure1() throws Exception {         // ----------- access only for ADMIN role
        this.mvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//    @Test                                               //-------------- WIP - no questionare
//    @WithMockUser(username = "user", password = "user", roles = "USER")
//    public void configure2() throws Exception {         // ----------- access only for ALL
//        this.mvc.perform(post("/questionnaire"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "SUBSCRIBED_USER")
    public void configure3() throws Exception {        // ----------- access only for SUBSCRIBED_USER & ADMIN role
        this.mvc.perform(get("/api/meal"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//                                                        //------------- WIP
//    @Test
//    @WithMockUser(username = "user", password = "user", roles = "ADMIN")
//    public void configure4() throws Exception {        // ----------- access only for ADMIN role
//        this.mvc.perform(get("/api/meal/**"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "SUBSCRIBED_USER")
    public void configure5() throws Exception {         // ----------- access only for SUBSCRIBED_USER & ADMIN role
        this.mvc.perform(get("/ingredient"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//                                                        //------------- WIP
//    @Test
//    @WithMockUser(username = "user", password = "user", roles = "ADMIN")
//    public void configure6() throws Exception {         // ----------- access only for ADMIN role
//        this.mvc.perform(get("/ingredient/**"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "USER")
    public void configure7() throws Exception {         // ----------- access only for ALL role
        this.mvc.perform(get("/swagger-ui.html"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//                                                        //------------- WIP
//    @Test
//    @WithMockUser(username = "user", password = "user", roles = "USER")
//    public void configure8() throws Exception {         // ----------- access only for ALL role
//        this.mvc.perform(get("/swagger-ui.html/**"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    @WithMockUser(username = "user", password = "user", roles = "USER")
//    public void configure9() throws Exception {         // ----------- access only for ALL role
//        this.mvc.perform(get("/swagger-resources.html/**"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
}