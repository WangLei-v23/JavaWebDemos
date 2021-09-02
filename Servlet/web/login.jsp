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
    <title>登录</title>
</head>
<body>

    <form action="/sessionLogin" method="post">
        <table>
            <tr>
                <td>
                    登录名：
                </td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>

            <tr>
                <td>
                    密码：
                </td>
                <td>
                    <input type="password" name="pwd">
                </td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
            </tr>

        </table>
    </form>

        <%
            String check = (String)request.getSession().getAttribute("check");
            if ("0".equals(check)){
                out.write("<h2>请输入用户名和密码！<h2/>");
            }else if ("1".equals(check)){
                out.write("<h2>您已退出！请重新登录！<h2/>");
            }
            request.getSession().invalidate();
        %>

</body>
</html>
