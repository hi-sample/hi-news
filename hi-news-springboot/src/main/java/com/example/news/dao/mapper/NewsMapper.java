package com.example.news.dao.mapper;

import com.example.news.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 15:38 <br/>
 */
@Mapper
@Repository
public interface NewsMapper {
    /**
     * 查询最新新闻
     * @return
     */
    List<News> queryTopNews();
}
