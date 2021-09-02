package com.s045;

import com.api.entity.card;
import com.api.utils.JDBCUtils;
import com.api.utils.MyBeanListHandler;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtilsTest {
    public static void main(String[] args) throws SQLException {
        //使用DBUtils
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from card";
//        String sql="select * from card where cno='sx009'";
        //使用集合查询
        List<card> queryResult = queryRunner.query(connection, sql, new MyBeanListHandler<card>(card.class));
        for (card card : queryResult) {
            System.out.println(card);
        }
//        System.out.println("-----------------------------------break---------------------------------");
        //单条 待条件查询
//        card sx009 = queryRunner.query(connection, sql, new BeanHandler<card>(card.class), "sx009");
        //MyBeanHandler结果处理
//        card queryResult = queryRunner.query(connection, sql, new MyBeanHandler<card>(card.class));
//        System.out.println(sx009);


        //使用自制DBUtils

    }
}
