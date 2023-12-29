package com.example.news.service.inter;

import com.example.news.entity.News;
import com.example.util.Result;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 15:24 <br/>
 */
public interface NewsServiceInter {
    Result<News> queryNews();
}
