package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieLogout")
public class cookieLogout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
            for (Cookie cookie: cookies
            ) {
                if (cookie.getName().equals("username")){
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    resp.sendRedirect("cookielogin.jsp");
                    return;
                }
            }
        }else{
            resp.sendRedirect("cookielogin.jsp");
        }

    }
}
