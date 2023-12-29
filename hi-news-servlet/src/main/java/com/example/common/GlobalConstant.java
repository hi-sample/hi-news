package com.example.common;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 09:13 <br/>
 */
public interface GlobalConstant {
    interface Db {
        String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String URL = "jdbc:sqlserver://test.s247.hifor.net;DatabaseName=demo_news;sendStringParametersAsUnicode=false";
        String USER = "news";
        String PASSWORD = "Ea!@jjX7Cp6WwhL5";
    }
}
