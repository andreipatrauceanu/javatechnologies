package com.example.javalab2;

import java.util.ArrayList;

public class Category {
    ArrayList<String> types = new ArrayList<String>() {
        {
            add("");
            add("cars");
            add("planes");
            add("trucks");
            add("boats");
        }
    };

    public Category() {
    }

    public void setTypes(ArrayList<String> str) {
        this.types = str;
    }

    public ArrayList<String> getTypes() {
        return types;
    }
}

