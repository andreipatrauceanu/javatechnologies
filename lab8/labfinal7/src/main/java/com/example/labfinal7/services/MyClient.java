package com.example.labfinal7.services;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class MyClient {

    private static String URI_VIEW = "http://localhost:8080/labfinal7-1.0-SNAPSHOT/webresources/view";
    private static String URI_DELETE = "http://localhost:8080/labfinal7-1.0-SNAPSHOT/webresources/delete/10";

    public static void main(String args[])  //static method
    {
        Client client = ClientBuilder.newClient()
                .register(DocumentFilter.class);
        String temp = client.target(URI_VIEW).request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("In client :\n" + temp);

        boolean res = client.target(URI_DELETE).request().delete(Boolean.class);
        System.out.println("In client :\n" + res);

        temp = client.target(URI_VIEW).request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("In client :\n" + temp);

    }


}
