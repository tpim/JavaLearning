package com.tpim.learning.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {


    public String greet() {
        return "greeting!";
    }

}
