package com.pabloquiroga.essentials.greetings;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String name){
        return "Hola " + name;
    }
}