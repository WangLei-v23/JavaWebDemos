<%--
  Created by IntelliJ IDEA.
  User: WangLei
  Date: 2021/8/8
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cooike首页</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        String username=null;
        if (cookies!=null){
            for (Cookie cookie: cookies
            ) {
                if (cookie.getName().equals("username")){
                    username=cookie.getValue();
                }
            }
        }else{


            response.sendRedirect("cookielogin.jsp");
        }
        if (username==null){
            response.sendRedirect("cookielogin.jsp");
        }
    %>

    <h1>欢迎登录，<%=username%></h1>
    <a href="/cookieLogout">退出登录</a>

</body>
</html>
