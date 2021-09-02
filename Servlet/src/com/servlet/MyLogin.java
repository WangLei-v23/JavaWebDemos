package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionLogin")
public class MyLogin extends HttpServlet{

    private final String USERNAME="admin";
    private final String PWD="123456";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        //校验通过 传值跳转
//        if (username.equals(USERNAME)&&pwd.equals(PWD)){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            resp.sendRedirect("homePage.jsp");
//        }
    }
}
