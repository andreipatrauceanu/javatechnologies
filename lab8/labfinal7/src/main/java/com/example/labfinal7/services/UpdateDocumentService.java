package com.example.labfinal7.services;

import com.example.labfinal7.entities.Document;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/update")
public class UpdateDocumentService {

    @Inject
    protected EntityManager userManagerPU;

    @PUT
    public void updateDocument(Document d) {
        Document employee = userManagerPU.find(Document.class, d.getId());
        userManagerPU.getTransaction().begin();
        employee.setName(d.getName());
        employee.setContent(d.getContent());
        employee.setAuthor(d.getAuthor());
        userManagerPU.getTransaction().commit();
    }
}
