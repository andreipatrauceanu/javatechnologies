package com.example.lab1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String key;
    private Integer value;
    private Boolean mock;
    private Boolean sync;
    private FileWriter myWriter;

    public void init() {
        try {
            myWriter = new FileWriter("repository.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeContentHTML(PrintWriter out) throws IOException {
        String current_date = new java.util.Date().toString();
        String buffer = key.repeat(value) + " " + current_date;
        myWriter.write(buffer);
        myWriter.flush();
        String current = Files.readString(Path.of("repository.txt"));
        out.println("<html><body>");
        out.println("<h1>" + current + "</h1>");
        out.println("</body></html>");
    }

    public void writeContentTXT(PrintWriter out) throws IOException {
        String current_date = new java.util.Date().toString();
        String buffer = key.repeat(value) + " " + current_date;
        myWriter.write(buffer);
        myWriter.flush();
        String current = Files.readString(Path.of("repository.txt"));
        out.println(current);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        key = request.getParameter("key");
        value = Integer.parseInt(request.getParameter("value"));
        mock = Boolean.parseBoolean(request.getParameter("mock"));
        sync = Boolean.parseBoolean(request.getParameter("sync"));
        String browserName = request.getHeader("User-Agent");
        if(browserName.contains("urllib")){
            if(mock == Boolean.TRUE){
                out.println("All the parameters were received on the server.");
            }
            else if(mock == Boolean.FALSE && sync == Boolean.FALSE){
                writeContentTXT(out);
            }
            else if(mock == Boolean.FALSE && sync == Boolean.TRUE){
                synchronized (myWriter) {
                    writeContentTXT(out);
                }
            }
        }
        else{
            if(mock == Boolean.TRUE){
                out.println("<html><body>");
                out.println("<h1>" + "All the parameters were received on the server." + "</h1>");
                out.println("</body></html>");
            }
            else if(mock == Boolean.FALSE && sync == Boolean.FALSE){
                writeContentHTML(out);
            }
            else if(mock == Boolean.FALSE && sync == Boolean.TRUE){
                synchronized (myWriter) {
                    writeContentHTML(out);
                }
            }
        }
        log(request.getMethod() + " " + request.getRemoteAddr() + " " + request.getHeader("User-Agent") + " "
                + request.getHeader("Accept-Language") + " " + key + " " + value + " " + mock + " " + sync);
    }

    public void destroy() {
    }
}