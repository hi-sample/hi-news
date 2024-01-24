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
import java.util.Date;


/**
 * @author IKin
 */
@WebServlet(value = "/news")
public class NewsServlet extends NewsBaseServlet {

    /**
     * 新闻明细接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.valueOf(request.getParameter("id"));

        //省略参数校验...

        NewsBean news = newsBean.queryById(id);

        // 显示提示内容后跳转新闻列表页
        request.setAttribute("news", news);
        RequestDispatcher dispatcher = request.getRequestDispatcher(GlobalConstant.VIEW_PRE + "/newsContent.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * 新闻修改接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        NewsBean news = new NewsBean();
        news.setTitle(request.getParameter("title"));
        news.setNewsContent(request.getParameter("newsContent"));
        news.setPublisher(request.getParameter("publisher"));
        news.setGmtModify(new Date());

        //省略参数校验...

        boolean result = false;
        if (request.getParameter("id")!=null){
            news.setId(Long.valueOf(request.getParameter("id")));
            result = newsBean.update(news);
        }else {
            result = newsBean.add(news);
        }

        if (result) {
            // 添加成功提示信息
            request.setAttribute("message", "保存成功.");
        } else {
            // 添加失败提示信息
            request.setAttribute("message", "保存失败.");
        }

        // 显示提示内容后跳转新闻列表页
        request.setAttribute("url", request.getContextPath() + "/");
        RequestDispatcher dispatcher = request.getRequestDispatcher(GlobalConstant.VIEW_PRE + "/message.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * 新闻删除接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.valueOf(request.getParameter("id"));

        //省略参数校验...

        boolean result = newsBean.delete(id);
        System.out.println("已删除:"+id + " : " + result);
        String message;
        if (result) {
            // 删除成功提示信息
            message =  "删除成功.";
        } else {
            // 删除失败提示信息
            message =  "删除失败.";
        }

        //设置返回内容编码
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //输出内容
        response.getWriter().write(message);
    }


}