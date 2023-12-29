package com.example.util;

import com.example.common.GlobalConstant;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 10:54 <br/>
 */
public class DbConn {
    public static Connection getConnection(){
        Connection conn = null;
        DbUtils.loadDriver(GlobalConstant.Db.JDBC_DRIVER);
        try {
            conn = DriverManager.getConnection(GlobalConstant.Db.URL, GlobalConstant.Db.USER, GlobalConstant.Db.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
