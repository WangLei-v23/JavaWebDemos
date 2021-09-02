<%--
  Created by IntelliJ IDEA.
  User: WangLei
  Date: 2021/8/1
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <%
      Cookie[] cookies = request.getCookies();
      for (int i = 0; i < cookies.length; i++) {
        out.write(cookies[i].getName()+"----"+cookies[i].getValue()+"<br/>");
      }
    %>

    <form action="/indexServlet" method="post">
      姓名：<input name="name" />
      <input type="submit" value="提交" />
    </form>

    <h1>Hello JSP</h1>
    <img src='10.png'/>
  </body>
</html>
