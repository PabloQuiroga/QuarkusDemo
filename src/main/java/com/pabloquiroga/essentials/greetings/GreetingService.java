package com.pabloquiroga.essentials.greetings;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class GreetingService {

    public String greeting(String name){
        return Optional.ofNullable(name)
                .map( n ->
                        (n.isEmpty()) ? "No se ha compartido un parametro para nombre"  : "Hola "+ n
                )
                .orElse("Hello from Quarkus");
    }
}