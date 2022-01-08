package pl.pjatk.zoo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooRestControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSuccess_exampleZoo() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/example");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Gdanskie zoo\",\"location\":\"Gdansk\",\"animalList\":[{\"id\":1,\"specimen\":\"mammal\",\"diet\":\"MEAT\",\"type\":\"LAND\",\"health\":\"HEALTHY\",\"hunger\":false}],\"open\":true}"));
    }

    @Test
    void shouldReturnSuccess_emptyZooForName() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/emptyWithName").param("name", "Some example name");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Some example name\",\"location\":\"Gdansk\",\"animalList\":null,\"open\":true}"));

    }
}
