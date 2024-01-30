package net.hifor.demo.news.controller;

import net.hifor.demo.common.dto.Result;
import net.hifor.demo.news.entity.News;
import net.hifor.demo.news.service.NewsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 15:21 <br/>
 * 说明： @CrossOrigin 用于支持跨域调用，生产环境一般不能使用，会有安全问题
 * 生产环境解决跨域调用会使用其他安全的方式来解决该问题
 */
@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    NewsService newsService;

    @GetMapping
    public Result list() {
        return newsService.queryList();
    }

    /**
     * 查询一条新闻
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result view(@PathVariable long id) {
        //省略参数校验...
        return newsService.queryById(id);
    }

    /**
     * 添加一条新闻
     *
     * @param news
     * @return
     */
    @PostMapping
    public Result add(@RequestBody News news) {
        //省略参数校验...
        return newsService.add(news);
    }

    /**
     * 修改一条新闻
     *
     * @param news
     * @return
     */
    @PatchMapping("/{id}")
    public Result update(@PathVariable long id, @RequestBody News news) {
        //省略参数校验...
        return newsService.update(news);
    }

    /**
     * 删除一条新闻
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id) {
        //省略参数校验...
        return newsService.delete(id);
    }
}
