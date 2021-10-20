package com.example.javalab2;

public class Record {
    String category;
    String key;
    Integer value;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Record(String category, String key, Integer value) {
        this.category = category;
        this.key = key;
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

}
