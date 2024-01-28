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
 * @description <br/>
 * @create 2024/1/23 12:08 <br/>
 */
@WebServlet(value = {"/news/add","/news/edit"})
public class NewsPageEditServlet extends NewsBaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id")!=null){
            long id = Long.valueOf(request.getParameter("id"));
            NewsBean news = newsBean.queryById(id);
            request.setAttribute("news", news);
        }

        // 转发到JSP页面展示新闻列表
        RequestDispatcher dispatcher = request.getRequestDispatcher(GlobalConstant.VIEW_PRE + "/newsEdit.jsp");
        dispatcher.forward(request, response);
    }
}
