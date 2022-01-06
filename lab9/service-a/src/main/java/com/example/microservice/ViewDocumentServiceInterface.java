package com.example.microservice;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8080/microservice/webresources")
@ApplicationScoped
public interface ViewDocumentServiceInterface {
    @GET
    @Path("/view")
    List<Document> getDocuments();
}
