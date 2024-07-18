package com.pabloquiroga.essentials.users;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {
    //simula DDBB
    private List<User> usersList;
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        usersList = new ArrayList<>();
        this.repository = repository;
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
        return usersList.stream().filter(u -> u.getId() == id).findFirst();
    }

    // Methods with DDBB
    public List<User> getAllUsers(){
        return repository.listAll();
    }

    public Optional<User> getById(Long id){
        return repository.findByIdOptional(id);
    }

    public Optional<User> getFirst(){
        return repository.findAll().stream().findFirst();
    }

    public void create(User user){
        repository.persist(user);
    }

}
