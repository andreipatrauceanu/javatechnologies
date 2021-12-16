package com.example.labfinal7.config;

import com.example.labfinal7.entities.Document;
import com.example.labfinal7.entities.User;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Authentication implements Serializable {

    private User currentUser;

    public void login(User user) {
        currentUser = user;
    }

    public String logout() {
        currentUser = null;
        return "home-page";
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void documentAdded(@Observes Document d){
        System.out.println("Document added successfully!");
    }
}
