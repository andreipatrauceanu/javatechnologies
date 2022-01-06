package com.example.labfinal7.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "register")
@RequestScoped
public class Register {
    @NotNull
    @Size(min=1, max=255)
    String username;

    @NotNull
    @Size(min=1, max=255)
    String password;

    @NotNull
    @Size(min=1, max=255)
    String role;

    List<String> roles = new ArrayList<String>();

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getRoles(){
        roles.add("admin");
        roles.add("reviewer");
        roles.add("author");
        return roles;
    }

}
