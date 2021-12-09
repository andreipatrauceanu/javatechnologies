package com.example.labfinal7.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean(name = "periodbean")
@RequestScoped
public class PeriodBean {
    @NotNull
    @Size(min=1, max=2)
    String starting_hour;

    @NotNull
    @Size(min=1, max=2)
    String end_hour;

    public String getStarting_hour() {
        return starting_hour;
    }

    public void setStarting_hour(String starting_hour) {
        this.starting_hour = starting_hour;
    }

    public String getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(String end_hour) {
        this.end_hour = end_hour;
    }
}
