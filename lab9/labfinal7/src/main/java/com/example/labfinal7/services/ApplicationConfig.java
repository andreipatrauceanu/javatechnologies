package com.example.labfinal7.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(AddDocumentService.class);
        resources.add(DeleteDocumentService.class);
        resources.add(ViewDocumentService.class);
        resources.add(UpdateDocumentService.class);
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

}
