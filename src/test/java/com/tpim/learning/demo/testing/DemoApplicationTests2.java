package com.tpim.learning.demo.testing;

import com.tpim.learning.demo.testing.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest //narrow the test to only the web layer and don't need start full application context.
@WebMvcTest(HelloController.class) // ask for one controller to be instantiated by using.
public class DemoApplicationTests2 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public  void  shouldReturnDefaultMessage() throws Exception{

        this.mockMvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello world!")));
        
    }

}
