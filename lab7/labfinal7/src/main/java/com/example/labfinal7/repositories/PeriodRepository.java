package com.example.labfinal7.repositories;
import com.example.labfinal7.beans.PeriodBean;
import com.example.labfinal7.entities.Period;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ManagedBean
public class PeriodRepository {
    @Inject
    protected EntityManager userManagerPU;

    public String addperiod(PeriodBean p){
        userManagerPU.getTransaction().begin();
        Period periodEntity = new Period();
        periodEntity.setStartingHour(p.getStarting_hour());
        periodEntity.setEndHour(p.getEnd_hour());
        userManagerPU.persist(periodEntity);
        userManagerPU.getTransaction().commit();
        return "user-page";
    }
}
