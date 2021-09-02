package com.servlet;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet extends MyGenericServlet {
    public MyHttpServlet() {
        System.out.println("实例化MyHttpServlet。。");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //分发请求
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        //获取请求类型
        String method = request.getMethod();
        if (method.equals("POST")){
            this.doPost(request,response);
        }
        if(method.equals("GET")){
            this.doGet(request,response);

        }
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response){

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
