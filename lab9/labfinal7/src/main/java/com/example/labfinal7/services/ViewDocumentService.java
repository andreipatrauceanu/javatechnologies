package com.example.labfinal7.services;

import com.example.labfinal7.entities.Document;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/view")
public class ViewDocumentService {

    @Inject
    protected EntityManager userManagerPU;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Document> getAllDocuments(@Context SecurityContext sc) {
        if (sc.isUserInRole("Admin")){
            Query query = userManagerPU.createQuery("SELECT d FROM Document d");
            List <Document> temp = query.getResultList();
            return temp;
        }
        throw new SecurityException("User is unauthorized.");
    }

}
