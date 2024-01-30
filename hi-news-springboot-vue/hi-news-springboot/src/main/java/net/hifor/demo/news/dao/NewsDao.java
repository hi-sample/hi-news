package net.hifor.demo.news.dao;

import net.hifor.demo.news.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 15:38 <br/>
 */
@Repository
public interface NewsDao {
    /**
     * 查询一条新闻
     *
     * @param id
     * @return
     */
    News queryById(@Param(value = "id") long id);

    /**
     * 查询前n条新闻
     *
     * @param topNum
     * @return
     */
    List<News> queryList(@Param(value = "topNum") int topNum);

    /**
     * 添加一条新闻
     *
     * @param news
     * @return
     */
    Long add(News news);

    /**
     * 修改一条新闻
     *
     * @param news
     * @return
     */
    int update(News news);

    /**
     * 删除一条新闻
     *
     * @param id
     * @return
     */
    int delete(long id);
}
