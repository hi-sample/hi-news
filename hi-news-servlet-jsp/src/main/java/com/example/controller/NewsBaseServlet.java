package com.example.controller;

import com.example.model.NewsBean;

import javax.servlet.http.HttpServlet;

/**
 * @author IKin <br/>
 * @description 新闻控制器基类 <br/>
 * @create 2024/1/24 15:59 <br/>
 */
public class NewsBaseServlet extends HttpServlet {
    protected NewsBean newsBean;

    public void init() {
        // 在初始化方法中创建NewsDAO对象
        newsBean = new NewsBean();
    }
}
