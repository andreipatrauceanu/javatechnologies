package com.example.javalab2;

import com.example.javalab2.filters.SimpleResponseWrapper;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String category;
    private String key;
    private Integer value;
    private Repository repo;

    public void init() {
        repo = new Repository();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String realCaptcha = (String) request.getSession().getAttribute("captcha");
        String userCaptcha = request.getParameter("captchaUser");
        System.out.println("Real one " + realCaptcha);
        System.out.println("User cap " + userCaptcha);
        if (realCaptcha.equals(userCaptcha)){
            category = request.getParameter("category");
            key = request.getParameter("key");
            value = Integer.parseInt(request.getParameter("value"));
            Cookie c1=new Cookie("Category", category);
            response.addCookie(c1);
            Record rec = new Record(category, key, value);
            repo.addRecord(rec);
            request.setAttribute("repository", repo.toString());
            getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        }
        else {
            request.setAttribute("errorMessage", "Wrong captcha. Please try again.");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
    }

    public void destroy() {
    }
}