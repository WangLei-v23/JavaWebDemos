package com.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/homePage.jsp")
public class loginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //判断是否登录
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        String username = (String)session.getAttribute("username");
        if (username==null||"".equals(username)){//重定向
            System.out.println("请求被拦截！");
            session.setAttribute("check","0");
            response.sendRedirect("login.jsp");
        }else{//放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

}
