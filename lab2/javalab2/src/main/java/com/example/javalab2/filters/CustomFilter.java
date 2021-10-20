package com.example.javalab2.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomFilter implements Filter {

    FilterConfig config;

    public void init(FilterConfig config) {
        this.config=config;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        String s= config.getInitParameter("category");

        HttpServletRequest request = (HttpServletRequest) req;
        ServletRequestWrapper wrapper = new HttpServletRequestWrapper(request) {
            @Override
            public String getParameter(String key) {
                String value = req.getParameter(key);
                if (value.equals("") && key.equals("category")) {
                    return s;
                }
                return value;
            }
        };
        chain.doFilter(wrapper, resp);
    }

    public void destroy() {}
}
