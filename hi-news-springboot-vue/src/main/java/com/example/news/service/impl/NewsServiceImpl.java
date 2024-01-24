package com.example.news.service.impl;

import com.example.news.dao.mapper.NewsMapper;
import com.example.news.entity.News;
import com.example.news.service.inter.NewsServiceInter;
import com.example.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 15:35 <br/>
 */
@Service
public class NewsServiceImpl implements NewsServiceInter {
    @Resource
    NewsMapper newsMapper;

    @Override
    public Result<News> queryNews() {
        List<News> list = newsMapper.queryTopNews();
        Result<News> result = new Result<>();
        result.setData(list);
        return result;
    }
}
