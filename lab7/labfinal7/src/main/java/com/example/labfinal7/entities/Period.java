package com.example.labfinal7.entities;

import javax.persistence.*;

@Table(name = "periods")
@Entity
@NamedQueries({
        @NamedQuery(name = "Period.getAll",
                query = "select p from Period p")
})

public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "starting_hour", nullable = false, length = 256)
    private String startingHour;

    @Column(name = "end_hour", nullable = false, length = 256)
    private String endHour;

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(String startingHour) {
        this.startingHour = startingHour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}