package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author IKin <br/>
 * @description 新闻实体类 <br/>
 * @create 2022/11/29 10:09 <br/>
 */
public class News {
    private Long id;
    private String title;

    @JSONField(name = "newsContent")
    private String news_content;
    private String publisher;

    @JSONField(name = "gmtCreate")
    private Date gmt_create;

    @JSONField(name = "gmtModify")
    private Date gmt_modify;



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

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modify() {
        return gmt_modify;
    }

    public void setGmt_modify(Date gmt_modify) {
        this.gmt_modify = gmt_modify;
    }
}
