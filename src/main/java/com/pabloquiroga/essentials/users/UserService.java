package com.pabloquiroga.essentials.users;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {
    //simula DDBB
    private List<User> usersList;

    public UserService() {
        usersList = new ArrayList<>();
        usersList.add(
                new User(
                        "Juan",
                        "Perez",
                        "01/01/2000"
                )
        );
    }

    public String getClassMessage() {
        return "Hello from UserService";
    }

    public User getDefaultUser() {
        return usersList.getFirst();
    }

    public boolean createUser(User u) {
        return usersList.add(u);
    }

    public List<User> getAll() {
        return usersList;
    }

    public Optional<User> getUserById(int id) {
        Optional<User> optional = Optional.empty();
        for(User u: usersList){
            if (u.id == id){
                optional = Optional.of(u);
                break;
            }
        }
        return optional;
    }
}
