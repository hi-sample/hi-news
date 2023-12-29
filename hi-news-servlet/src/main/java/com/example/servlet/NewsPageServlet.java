package com.example.servlet;

import com.example.entity.News;
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

@WebServlet(name = "helloServlet", value = "/news")
public class NewsPageServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "新闻列表";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection conn = DbConn.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        ResultSetHandler<List<News>> resultHandler = new BeanListHandler<News>(News.class);
        List<News> list = null;
        try {
            list = queryRunner.query(conn, "SELECT top 10 * FROM news order by id desc", resultHandler);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        // new list
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<ul>");
        for (News news : list) {
            out.println("<li>" + news.getTitle() + "    " + news.getPublisher()+ "    " + news.getGmt_create() +  "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }



    public void destroy() {
    }
}