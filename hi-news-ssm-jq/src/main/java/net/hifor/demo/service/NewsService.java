package net.hifor.demo.service;

import net.hifor.demo.dto.Result;
import net.hifor.demo.entity.News;

import java.util.List;

/**
 * @author IKin <br/>
 * @description 新闻业务逻辑 <br/>
 * @create 2024/1/26 11:23 <br/>
 */
public interface NewsService {
    /**
     * 查询一条新闻
     * @param id
     * @return
     */
    News queryById(long id);

    /**
     * 查询前n条新闻
     * @param topNum
     * @return
     */
    List<News> queryList(int topNum);

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
