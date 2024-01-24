package com.example.news.controller;

import com.example.news.entity.News;
import com.example.news.service.inter.NewsServiceInter;
import com.example.util.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 15:21 <br/>
 * 说明： @CrossOrigin 用于支持跨域调用，生产环境一般不能使用，会有安全问题
 *       生产环境解决跨域调用会使用其他安全的方式来解决该问题
 */
@CrossOrigin
@RestController
@RequestMapping()
public class NewsController {
    @Resource
    NewsServiceInter newsServiceInter;

    @GetMapping({"/api/news","/b"})
    public Result<News> queryTopNews() {
        Result<News> result = newsServiceInter.queryNews();
        return result;
    }
}
