package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理GET请求");
        //jsp雏形
//        resp.getWriter().write("<h1>Hello JSP</h1>");
//        resp.getWriter().write("<img src='10.png'/>");

        //req获取地址参数
//        String[] names = req.getParameterValues("name");
//        System.out.println(Arrays.toString(names));


        //创建一个字符串
        String str = "Hello WangLei, 欢迎使用本页面";
        //设置发送数据的键值对
//        req.setAttribute("str",str);
        //获取目标
//        RequestDispatcher dispatcher = req.getRequestDispatcher("test.jsp");
        //跳转至目标资源 并将字符串传给jsp 地址栏仍是 http://localhost:8080/indexServlet
//        dispatcher.forward(req,resp);

        //使用session 重定向传递参数
        HttpSession httpSession=req.getSession();
        httpSession.setAttribute("str",str);
        //重定向 地址栏变为 http://localhost:8080/test.jsp
        resp.sendRedirect("test.jsp");

        //resp常用方法
//        String str = "Hello WangLei, 欢迎使用本页面";
//        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().write(str);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理POST请求");
        String name = req.getParameter("name");
        System.out.println(name);
        resp.setCharacterEncoding("GBK");
        resp.getWriter().write("<h1>Hello "+name+", 欢迎登录</h1>");
    }
}
