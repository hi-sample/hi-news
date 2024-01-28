package net.hifor.demo.dao;

import net.hifor.demo.entity.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author IKin <br/>
 * @description 新闻数据持久化 <br/>
 * @create 2024/1/26 11:31 <br/>
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
    List<News> queryList(int topNum);

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
