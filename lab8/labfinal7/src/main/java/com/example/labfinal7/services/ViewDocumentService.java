package com.example.labfinal7.services;

import com.example.labfinal7.entities.Document;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/view")
public class ViewDocumentService {

    @Inject
    protected EntityManager userManagerPU;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Document> getAllDocuments() {
        Query query = userManagerPU.createQuery("SELECT d FROM Document d");
        List <Document> temp = query.getResultList();
        return temp;
    }

}
