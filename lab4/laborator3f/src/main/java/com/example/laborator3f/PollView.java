package com.example.laborator3f;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;

@ManagedBean(name = "pollView")
public class PollView implements Serializable {
    public String exams_count;

    public PollView() {
    }

    public String getExams_count() {
        return exams_count;
    }

    public void setExams_count(String exams_count) {
        this.exams_count = exams_count;
    }

    public void getExams(){
        try {
            PreparedStatement st_1 = DataBase.getInstance().getConnection().prepareStatement("select count(*) from exam");
            ResultSet rs_1 = st_1.executeQuery();
            while (rs_1.next()) {
                setExams_count(String.valueOf(rs_1.getInt("count")));
            }
            System.out.println("Exams count " + getExams_count());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}