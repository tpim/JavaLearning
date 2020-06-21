package com.tpim.learning.demo.testing;

import com.tpim.learning.demo.testing.GreetingController;
import com.tpim.learning.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest //narrow the test to only the web layer and don't need start full application context.
@WebMvcTest(GreetingController.class) // ask for one controller to be instantiated by using.
public class DemoApplicationTests3 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean //create and inject service to for controller.
    private GreetingService service;

    @Test
    public  void  shouldReturnDefaultMessage() throws Exception{

        when(service.greet()).thenReturn("greeting!");
        this.mockMvc.perform(get("/greeting")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("greeting!")));
        
    }

}
