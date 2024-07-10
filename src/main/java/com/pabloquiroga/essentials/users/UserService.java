package com.pabloquiroga.essentials.users;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UserService {
    private final Mocks mocks;

    public UserService(Mocks m){
        this.mocks = m;
    }

    public User getDefaultUser(){
        return mocks.u1;
    }

    public User getUserById(int id) {
        return mocks.randonUser; //TODO
    }

    public boolean createUser(User u){
        return mocks.addNewUser(u);
    }

    public void updateUser(){
        //TODO
    }

    public List<User> getAll() {
        return mocks.getUsersList();
    }
}
