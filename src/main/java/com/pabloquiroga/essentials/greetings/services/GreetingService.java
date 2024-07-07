package com.pabloquiroga.essentials.greetings.services;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String name){
        return "Hello " + name;
    }
}
