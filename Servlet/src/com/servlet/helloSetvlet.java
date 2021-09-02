package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/hello")
public class helloSetvlet implements Servlet {

    public helloSetvlet() {
        System.out.println("执行helloSetvlet构造器。。");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("执行init方法。。");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("执行destroy销毁servlet对象。。");
    }
}
