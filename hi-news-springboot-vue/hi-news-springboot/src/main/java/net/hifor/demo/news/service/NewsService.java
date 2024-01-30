package net.hifor.demo.news.service;

import net.hifor.demo.news.entity.News;
import net.hifor.demo.common.dto.Result;

import java.util.List;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 15:24 <br/>
 */
public interface NewsService {
    /**
     * 查询一条新闻
     * @param id
     * @return
     */
    Result queryById(long id);

    /**
     * 查询前n条新闻
     * @return
     */
    Result queryList();

    /**
     * 添加一条新闻
     * @param news
     * @return
     */
    Result add(News news);

    /**
     * 修改一条新闻
     * @param news
     * @return
     */
    Result update(News news);

    /**
     * 删除一条新闻
     * @param id
     * @return
     */
    Result delete(long id);
}
