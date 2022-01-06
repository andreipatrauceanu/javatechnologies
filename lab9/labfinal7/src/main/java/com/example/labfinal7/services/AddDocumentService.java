package com.example.labfinal7.services;


import com.example.labfinal7.entities.Document;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/add")
public class AddDocumentService {

    @Inject
    protected EntityManager userManagerPU;

    @POST
    @RolesAllowed("Admin")
    public void addDocument(Document document) {
        userManagerPU.getTransaction().begin();
        userManagerPU.persist(document);
        userManagerPU.getTransaction().commit();
    }

}
