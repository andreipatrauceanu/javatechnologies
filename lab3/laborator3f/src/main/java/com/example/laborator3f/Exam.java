package com.example.laborator3f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ManagedBean(name = "exam")
@RequestScoped
public class Exam {
    String id;
    String name;
    String starting_time;
    String duration_hours;
    String result;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDuration_hours() {
        return duration_hours;
    }

    public void setDuration_hours(String duration_hours) {
        this.duration_hours = duration_hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarting_time() {
        return starting_time;
    }

    public void setStarting_time(String starting_time) {
        this.starting_time = starting_time;
    }

    public String getResult() {
        return result;
    }

    public void add()
    {
        try {
            PreparedStatement st = DataBase.getInstance().getConnection().prepareStatement("INSERT INTO exam (NAME, DURATION_HOURS, STARTING_TIME) VALUES (?, ?, ?)");
            st.setString(1, name);
            st.setString(2, duration_hours);
            st.setString(3, starting_time);
            st.executeUpdate();
            st.close();
            result = "Course added successfully.";
        } catch (SQLException e) {
            e.printStackTrace();
            result = "The course has not been added. Please retry.";
        }
    }
}


