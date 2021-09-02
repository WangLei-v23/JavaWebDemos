package com.s044;

import java.sql.*;

public class testCUD {
    public static void main(String[] args)  {
        cudTest("sx013","jdbc013","j013");
    }

    public static void cudTest(String cno,String name,String className){
        //加载JDBC驱动  新版本jdk自动完成 不必手动加载
//        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接   url  username  password
        String url = "jdbc:mysql://localhost:3306/mytestdb2?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "123456";
        Connection connection=null;
        try{
            //获取连接
            connection = DriverManager.getConnection(url, user, password);
            //待执行的sql
            String sql = "insert into card (cno,name,class) values (?,?,?)";
            //获取Statement子类，将sql中的参数进行拼接
            //好处：1、提供占位符的功能，避免拼接字符串导致的sql错误
            //     2、防止 SQL 注入，安全性更高
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cno);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,className);
            //增 删 改 都用 executeUpdate 返回产生影响的数据行数
            //查询用 executeQuery 返回ResultSet
            //exexute(sql) 返回boolean  表示返回值是否为ResultSet类型
            int i = preparedStatement.executeUpdate();
            System.out.println(i);

            //事务提交
            connection.commit();
            connection.close();
        }catch (Exception e){
            try {
                //事务回滚
                //保证多条sql执行，其中一条发生错误时，回滚至事务未执行的状态
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
