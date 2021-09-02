package com.s044;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testR {
    public static void main(String[] args) throws Exception {
        //获取连接   url  username  password
        String url = "jdbc:mysql://localhost:3306/mytestdb2?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "123456";
        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //待执行的sql
        String sql = "select * from card";
        Statement statement = connection.createStatement();
        //查询用 executeQuery
        ResultSet resultSet = statement.executeQuery(sql);
        //处理返回的ResultSet结果集
        while (resultSet.next()){
            String res="";
            //也可以根据列的字段名取值 resultSet.getString("cno");
            res+=resultSet.getString(1)+"---";
            res+=resultSet.getString(2)+"---";
            res+=resultSet.getString(3);
            System.out.println(res);
        }

    }
}
