package com.s045;

import com.api.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    /**优化思路
     * 1 将重复代码提取为工具类中的函数（减少冗余代码
     * 2 配置连接池（解决因重复获取连接，导致的资源浪费问题
     * 3 将工具类中获取连接的方式，改为通过连接池获取
     */
    public static void cudTest(String cno,String name,String className){
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        try {
            //从工具类获取连接
            connection = JDBCUtils.getConnection();
            //定义sql
            String sql = "insert into card (cno,name,class) values (?,?,?)";
            //占位符替换
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cno);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,className);
            //输出运行结果
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            //释放资源
            JDBCUtils.release(connection,preparedStatement,null);
        }
    }


    public static void main(String[] args) {
        cudTest("sx011","sister02","G19");
    }




}
