package com.example.servlet;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.News;
import com.example.entity.Result;
import com.example.util.DbConn;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "helloServlet", value = "/api/news")
public class NewsApiServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result<News> result = new Result<>();
        Connection conn = DbConn.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        ResultSetHandler<List<News>> resultHandler = new BeanListHandler<>(News.class);
        List<News> list = null;
        try {
            list = queryRunner.query(conn, "SELECT top 10 id,title,publisher,gmt_create FROM news order by id desc", resultHandler);
        } catch (SQLException e) {
            result.setCode(500);
            result.setMsg("数据库查询异常");
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        // news list
        PrintWriter out = response.getWriter();
        if (result.getCode()==0){
            result.setData(list);
        }
        out.println(JSONObject.toJSONString(result));
    }

    public void destroy() {
    }
}