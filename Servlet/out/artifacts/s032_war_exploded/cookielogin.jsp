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
    <title>cookie登录</title>
</head>
<body>
<form action="/cookieLogin" method="post">
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

</body>
</html>
