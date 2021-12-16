package com.example.labfinal7.services;
import com.example.labfinal7.entities.Document;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Provider
public class DocumentFilter implements ClientResponseFilter {

    static String list_of_docs = null;
    @Inject
    protected EntityManager userManagerPU;


    public void filter(ClientRequestContext request,
                       ClientResponseContext response) throws IOException {
        if(request.getMethod().equalsIgnoreCase("GET")){
            try (InputStream entityStream = response.getEntityStream()) {
                if (entityStream != null) {
                    byte[] bytes = IOUtils.toByteArray(entityStream);
                    response.setEntityStream(new ByteArrayInputStream(bytes));
                    list_of_docs = new String(bytes);
                }
            }
        }

        if((request.getMethod().equalsIgnoreCase("PUT") ||
           request.getMethod().equalsIgnoreCase("POST") ||
           request.getMethod().equalsIgnoreCase("DELETE")) && list_of_docs!=null){
            Query query = userManagerPU.createQuery("SELECT d FROM Document d");
            List<Document> temp = query.getResultList();
            list_of_docs = new Gson().toJson(temp);
        }

        if(response.getStatus()==200){
            System.out.println("In filter: status 200.");
        }

        System.out.println("In filter: "  + "after  " + request.getMethod() + "\n" + list_of_docs);

        }
}

