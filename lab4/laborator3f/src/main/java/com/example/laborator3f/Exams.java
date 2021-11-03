package com.example.laborator3f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "exams")
@RequestScoped
public class Exams {
    public List<Exam> examsList;

    public List<Exam> getExamsList() {
        examsList = new ArrayList<>();
        try {
            PreparedStatement st = DataBase.getInstance().getConnection().prepareStatement("select * from exam");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String duration_hours = rs.getString("duration_hours");
                String starting_time = rs.getString("starting_time");
                Exam e = new Exam();
                e.setId(id);
                e.setName(name);
                e.setDuration_hours(duration_hours);
                e.setStarting_time(starting_time);
                examsList.add(e);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return examsList;
    }
}
