package com.example.labfinal7.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean(name = "docbean")
@RequestScoped
public class DocBean {
    @NotNull
    @Size(min=1, max=255)
    String name;

    @NotNull
    @Size(min=1, max=255)
    String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
