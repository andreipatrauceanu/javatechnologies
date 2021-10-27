package com.example.laborator3f;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "student")
@RequestScoped
public class Student {
    String name;
    String exams;
    String result;

    public Student() {
    }

    public String getExams() {
        return exams;
    }

    public void setExams(String exams) {
        this.exams = exams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void add()
    {
        try {
            PreparedStatement st = DataBase.getInstance().getConnection().prepareStatement("INSERT INTO student (NAME, EXAMS) VALUES (?, ?)");
            st.setString(1, name);
            st.setString(2, exams);
            st.executeUpdate();
            st.close();
            result = "Student added successfully.";
        } catch (SQLException e) {
            e.printStackTrace();
            result = "The student has not been added. Please retry.";
        }
    }

}

