package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieLogin")
public class cookieLogin extends HttpServlet {

    private final String USERNAME="admin";
    private final String PWD="123456";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        if (username.equals(USERNAME)&&pwd.equals(PWD)){
            Cookie cookie = new Cookie("username",username);
            cookie.setMaxAge(600);
            resp.addCookie(cookie);
            resp.sendRedirect("cookiehome.jsp");
        }else{
            resp.sendRedirect("cookielogin.jsp");
        }
    }
}
