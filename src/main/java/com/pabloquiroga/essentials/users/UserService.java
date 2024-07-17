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
    }

    public String getClassMessage() {
        return "Hello from UserService";
    }

    public Optional<User> getDefaultUser() {
        return usersList.stream().findFirst();
    }

    public boolean createUser(User u) {
        return usersList.add(u);
    }

    public List<User> getAll() {
        return usersList;
    }

    public Optional<User> getUserById(int id) {
        return usersList.stream().filter(u -> u.getID() == id).findFirst();
    }
}
