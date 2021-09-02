<%--
  Created by IntelliJ IDEA.
  User: WangLei
  Date: 2021/8/8
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<%--    <%--%>
<%--        String username = (String) session.getAttribute("username");--%>
<%--    %>--%>
<%--    <h1>欢迎<%=username%>登录本系统</h1><br/>--%>

    <%--使用EL表达式--%>
    <h1>欢迎${username}登录本系统</h1>
    <a href="/logout">退出登录</a>
</body>
</html>
