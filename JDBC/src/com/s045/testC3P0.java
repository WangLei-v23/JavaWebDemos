package com.s045;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class testC3P0 {

    /**
     * 将连接池的设置，提取到配置文件，变动时修改配置文件即可
     */
    public static void main(String[] args) {
        //从连接池获取连接
        ComboPooledDataSource dataSource=null;
        Connection connection=null;
        try {
            dataSource=new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mytestdb2?useUnicode=true&characterEncoding=UTF-8");
            dataSource.setUser("root");
            dataSource.setPassword("123456");
            //初始化连接数
            dataSource.setInitialPoolSize(20);
            //增加连接时的最小剩余连接数
            dataSource.setMinPoolSize(2);
            //一次增量获取连接个数
            dataSource.setAcquireIncrement(5);
            //最大连接数
            dataSource.setMaxPoolSize(50);

            //从连接池获取连接
            connection=dataSource.getConnection();

            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
