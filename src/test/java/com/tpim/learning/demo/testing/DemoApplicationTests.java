package com.tpim.learning.demo.testing;





import static org.assertj.core.api.Assertions.assertThat;

import com.tpim.learning.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

//@SpringBootTest // tell spring boot look for main configuration class( one with SpringBootApplication), use this to start application context.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)  // start the server with random port and inject this port to @LocalSserverPort.
public class DemoApplicationTests{


    @LocalServerPort
    private int port;


//    @Autowired  //is injected before the test methods are run.
//    private HelloController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private GreetingService service;


    @Test
    public  void  greetingShouldReturnDefaultMessage() throws  Exception{

        assertThat(this.restTemplate.getForObject("http://localhost:" + port +"/",String.class)).contains("Hello world!");

    }

//    @Test
//    public void contextLoads() throws  Exception{
//
//      assertThat(controller).isNotNull();
//
//    }
}
