package com.pabloquiroga.essentials.users;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    private final List<User> usersList; //simula DDBB
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
        user.setAge(User.setAgeFromBirthdate(user.getBirthdate()));
        repository.persist(user);
    }

    public boolean delete(Long id){
        return repository.deleteById(id);
    }

    public boolean update(String id, User user){
        var updatedUser = repository.findById(Long.valueOf(id));

        if(updatedUser != null){
            updatedUser.setName(user.getName());
            updatedUser.setSurname(user.getSurname());
            updatedUser.setBirthdate(user.getBirthdate());
            updatedUser.setAge(user.getAge());

            repository.persist(updatedUser);
            return true;
        } else {
            return false;
        }
    }

    public List<User> getAdultUsers(){
        return repository.list("age >= 18");
    }

    public List<User> getUntilAge(int age){
        return repository.list("age <= ?", age);
    }

    public List<User> getBetweenAges(int menor, int mayor){
        return repository.list("age > ?1 AND age < ?2", menor, mayor);
    }
}
