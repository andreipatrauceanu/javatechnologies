package com.example.javalab2.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/hello-servlet"})
public class FilterDecorator implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SimpleResponseWrapper wrapper = new SimpleResponseWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, wrapper);
        String content = wrapper.toString();
        String prelude = "<prelude>" +
                "<h1> Prelude added by FilterDecorator </h1>" +
                "</prelude>";
        String footer = "<footer>" +
                "<h1> Footer added by FilterDecorator </h1>" +
                "</footer>";
        String buffer_final = prelude + content + footer;
        PrintWriter out = servletResponse.getWriter();
        out.write(buffer_final);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
