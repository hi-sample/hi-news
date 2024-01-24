package com.example.controller;

import com.example.common.GlobalConstant;
import com.example.model.NewsBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author IKin <br/>
 * @description 首页 <br/>
 * @create 2024/1/23 11:08 <br/>
 */
@WebServlet(value = "/")
public class HomeServlet extends HttpServlet {

    private NewsBean newsBean;

    public void init() {
        // 在初始化方法中创建NewsDAO对象
        newsBean = new NewsBean();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将新闻列表存储在request中
        request.setAttribute("newsList", newsBean.queryList(10));

        // 转发到JSP页面展示新闻列表
        RequestDispatcher dispatcher = request.getRequestDispatcher(GlobalConstant.VIEW_PRE + "/newsList.jsp");
        dispatcher.forward(request, response);
    }
}
