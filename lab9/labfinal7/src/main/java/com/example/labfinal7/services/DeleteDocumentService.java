package com.example.labfinal7.services;

import com.example.labfinal7.entities.Document;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/delete")
public class DeleteDocumentService {

    @Inject
    protected EntityManager userManagerPU;

    @DELETE
    @Path("{id}")
    public boolean deleteDocument(@PathParam("id") Integer id) {
        Document employee = userManagerPU.find(Document.class, id);
        if(employee == null){
            return false;
        }
        else{
            userManagerPU.getTransaction().begin();
            userManagerPU.remove(employee);
            userManagerPU.getTransaction().commit();
            return true;
        }
    }
}
