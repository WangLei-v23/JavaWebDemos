<%--
  Created by IntelliJ IDEA.
  User: WangLei
  Date: 2021/8/4
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test JSP</title>
</head>
<body>
    <%
//        String str =(String) request.getAttribute("str");
        String str =(String) session.getAttribute("str");
        String id=session.getId();
        Cookie cookie = new Cookie("name2222", "MyCookie2222");
        cookie.setMaxAge(30);
        response.addCookie(cookie);

    %>
    <h1>
        session.getAttribute=<%=str%><br/>
        session.getId=<%=id%><br/>
        cookie.getName=<%=cookie.getName()%><br/>
        cookie.getValue()=<%=cookie.getValue()%><br/>
    </h1>

</body>
</html>
