package com.example.labfinal7.services;
import org.apache.commons.io.IOUtils;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Provider
public class DocumentFilter implements ClientResponseFilter {

    static String list_of_docs = null;


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
            String temp = request.getUri().getPath();
            System.out.println(temp);
            String[] splits = temp.split("/");
            System.out.println(Arrays.toString(splits));
        }

        if(response.getStatus()==200){
            System.out.println("In filter: status 200.");
        }

        System.out.println("In filter: "  + "after  " + request.getMethod() + "\n" + list_of_docs);

        }
}

