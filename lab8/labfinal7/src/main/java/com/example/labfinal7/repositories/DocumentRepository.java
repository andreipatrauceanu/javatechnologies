package com.example.labfinal7.repositories;

import com.example.labfinal7.beans.DocBean;
import com.example.labfinal7.config.Authentication;
import com.example.labfinal7.entities.Document;
import com.example.labfinal7.entities.User;

import javax.enterprise.event.Event;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ManagedBean
public class DocumentRepository {

    @Inject
    protected EntityManager userManagerPU;

    @Inject
    private Authentication auth;

    protected @Inject
    Event<Document> docEvent;

    public List<Document> docs;

    public String add(DocBean d){
        userManagerPU.getTransaction().begin();
        Document docEntity = new Document();
        docEntity.setName(d.getName());
        docEntity.setAuthor(auth.getCurrentUser().getUsername());
        docEntity.setContent(d.getContent());
        userManagerPU.persist(docEntity);
        userManagerPU.getTransaction().commit();
        docEvent.fire(docEntity);
        return "user-page";
    }

    public List<Document> getDocs(){
        TypedQuery<Document> query = userManagerPU.createNamedQuery("Document.getAll", Document.class);
        docs = query.getResultList();
        return docs;
    }

}
