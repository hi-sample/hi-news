package net.hifor.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import net.hifor.demo.dao.NewsDao;
import net.hifor.demo.dto.Result;
import net.hifor.demo.entity.News;
import net.hifor.demo.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2024/1/26 11:26 <br/>
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    NewsDao newsDao;

    @Override
    public News queryById(long id) {
        return newsDao.queryById(id);
    }

    @Override
    public List<News> queryList(int topNum) {
        List<News> list = newsDao.queryList(topNum);
        return list;
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
