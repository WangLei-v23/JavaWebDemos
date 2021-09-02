package com.api.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

/**
 * JDBC工具类
 */
public class JDBCUtils {

//    private static String URL = "jdbc:mysql://localhost:3306/mytestdb2?useUnicode=true&characterEncoding=UTF-8";
//    private static String USER = "root";
//    private static String PASSWORD = "123456";

    //获取连接 改为从连接池获取
    public static Connection getConnection(){
        Connection connection=null;
        //加载驱动获取连接
//       connection= DriverManager.getConnection(URL, USER, PASSWORD);
        //从连接池获取连接
        ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
        try {
            connection=dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    //释放资源
    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if (connection!=null) {
                connection.close();
            }
            if (preparedStatement!=null) {
                preparedStatement.close();
            }
            if (resultSet!=null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
