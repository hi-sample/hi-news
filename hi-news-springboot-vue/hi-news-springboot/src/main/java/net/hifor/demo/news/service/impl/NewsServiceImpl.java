package net.hifor.demo.news.service.impl;

import net.hifor.demo.common.dto.Result;
import net.hifor.demo.news.dao.NewsDao;
import net.hifor.demo.news.entity.News;
import net.hifor.demo.news.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 15:35 <br/>
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    NewsDao newsDao;

    @Override
    public Result<News> queryById(long id) {
        News news = newsDao.queryById(id);
        Result<News> result = new Result<>();
        result.setModel(news);
        return result;
    }

    @Override
    public Result<News> queryList() {
        List<News> list = newsDao.queryList(10);
        Result<News> result = new Result<>();
        result.setData(list);
        return result;
    }

    @Override
    public Result add(News news) {
        Result<Long> result = new Result();
        long id = newsDao.add(news);
        if (id > 0) {
            result.setModel(id);
            return result;
        }
        result.setCode(1001);
        result.setMsg("数据插入异常");
        return result;
    }

    @Override
    public Result update(News news) {
        Result result = new Result();
        int rows = newsDao.update(news);
        if (rows > 0) {
            return result;
        }
        result.setCode(1002);
        result.setMsg("数据更新异常");
        return result;
    }

    @Override
    public Result delete(long id) {
        Result result = new Result();
        int rows = newsDao.delete(id);
        if (rows > 0) {
            return result;
        }
        result.setCode(1003);
        result.setMsg("数据删除异常");
        return result;
    }
}
