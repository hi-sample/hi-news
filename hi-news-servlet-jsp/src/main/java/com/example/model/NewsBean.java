package com.example.model;

import com.example.util.DbConn;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author IKin <br/>
 * @description 新闻实体类 <br/>
 * @create 2022/11/29 10:09 <br/>
 */
public class NewsBean {
    private Long id;
    private String title;
    private String newsContent;
    private String publisher;

    private Date gmtCreate;

    private Date gmtModify;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 查询一条新闻记录
     *
     * @param id
     * @return
     */
    public NewsBean queryById(long id) {
        Connection conn = null;
        BeanHandler<NewsBean> beanHandler = new BeanHandler<>(NewsBean.class);
        NewsBean news = null;
        try {
            conn = DbConn.getConnection();
            String sql = "SELECT id,title,news_content as newsContent,publisher,gmt_create as gmtCreate,gmt_modify as gmtModify FROM news where id=?";
            QueryRunner queryRunner = new QueryRunner();
            news = queryRunner.query(conn, sql, beanHandler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return news;
    }

    /**
     * 获取新闻最新前topNum条
     *
     * @param topNum
     * @return
     */
    public List<NewsBean> queryList(int topNum) {
        Connection conn = null;
        BeanListHandler<NewsBean> beanListHandler = new BeanListHandler<>(NewsBean.class);
        List<NewsBean> list = null;
        try {
            conn = DbConn.getConnection();
            String sql = "SELECT top " + topNum + " id,title,publisher,gmt_create as gmtCreate FROM news order by id desc";
            QueryRunner queryRunner = new QueryRunner();
            list = queryRunner.query(conn, sql, beanListHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    /**
     * 添加一条新闻
     *
     * @param news
     */
    public boolean add(NewsBean news) {
        Connection conn = null;
        int rows = 0;
        Long id = 0L;
        try {
            conn = DbConn.getConnection();
            String sql = "insert into news (title, news_content, publisher) values (?, ?, ?)";
            Object[] params = {news.getTitle(), news.getNewsContent(), news.getPublisher()};
            QueryRunner queryRunner = new QueryRunner();
            rows = queryRunner.update(conn, sql, params);
            System.out.println("rows: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        System.out.println(rows);
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改一条记录
     * @param news
     * @return
     */
    public boolean update(NewsBean news) {
        Connection conn = null;
        int rows = 0;
        Long id = 0L;
        try {
            conn = DbConn.getConnection();
            String sql = "UPDATE news SET title = ?, news_content = ?, publisher = ?, gmt_modify = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,news.getTitle());
            ps.setString(2,news.getNewsContent());
            ps.setString(3,news.getPublisher());
            ps.setTimestamp(4,new java.sql.Timestamp(news.getGmtModify().getTime()));
            ps.setLong(5,news.getId());
            rows = ps.executeUpdate();
            System.out.println("rows: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        System.out.println(rows);
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(long id) {
        Connection conn = null;
        int rows = 0;
        try {
            conn = DbConn.getConnection();
            String sql = "DELETE FROM news where id=?";
            QueryRunner queryRunner = new QueryRunner();
            rows = queryRunner.update(conn, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }
}
