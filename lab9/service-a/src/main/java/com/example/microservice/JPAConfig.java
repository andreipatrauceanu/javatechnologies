package com.example.microservice;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAConfig {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DocumentPU");

    @Produces
    public EntityManager createEM(){
        return emf.createEntityManager();
    }
}