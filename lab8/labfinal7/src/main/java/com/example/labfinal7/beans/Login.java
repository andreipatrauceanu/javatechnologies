package com.example.labfinal7.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean(name = "login")
@RequestScoped
public class Login {

    @NotNull
    @Size(min=1, max=255)
    String username;

    @NotNull
    @Size(min=1, max=255)
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
