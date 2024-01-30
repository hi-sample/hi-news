package net.hifor.demo.controller;

import net.hifor.demo.dto.Result;
import net.hifor.demo.entity.News;
import net.hifor.demo.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author IKin <br/>
 * @description 新闻 <br/>
 * @create 2024/1/26 11:02 <br/>
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Resource
    NewsService newsService;

    /**
     * 新闻列表页面
     * @param model
     * @return
     */
    @GetMapping
    public String pageList(Model model) {
        model.addAttribute("newsList", newsService.queryList());
        return "newsList";
    }

    /**
     * 新闻明细页面
     * @param id
     * @return
     */
    @GetMapping(value = "/view/{id}")
    public ModelAndView pageView(@PathVariable long id) {
        //省略参数校验...
        ModelAndView modelAndView = new ModelAndView("newsView");
        modelAndView.addObject("news", newsService.queryById(id));
        return modelAndView;
    }

    /**
     * 添加新闻页面
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView pageAdd() {
        ModelAndView modelAndView = new ModelAndView("newsEdit");
        return modelAndView;
    }

    /**
     * 编辑新闻页面
     * @param id
     * @return
     */
    @GetMapping(value = "/edit/{id}")
    public ModelAndView pageEdit(@PathVariable long id) {
        //省略参数校验...
        ModelAndView modelAndView = new ModelAndView("newsEdit");
        modelAndView.addObject("news", newsService.queryById(id));
        return modelAndView;
    }

    /**
     * 添加一条新闻
     * @param news
     * @return
     */
    @ResponseBody
    @PostMapping
    public Result add(@RequestBody News news) {
        //省略参数校验...
        return newsService.add(news);
    }

    /**
     * 修改一条新闻
     * @param news
     * @return
     */
    @ResponseBody
    @PatchMapping
    public Result update(@RequestBody News news) {
        //省略参数校验...
        return newsService.update(news);
    }

    /**
     * 删除一条新闻
     * @param id
     * @return
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id) {
        //省略参数校验...
        return newsService.delete(id);
    }
}
