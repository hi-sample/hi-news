package net.hifor.demo.controller;

import net.hifor.demo.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author IKin <br/>
 * @description 首页 <br/>
 * @create 2024/1/26 10:24 <br/>
 */
@Controller
public class HomeController {

    @Resource
    NewsService newsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String page(Model model) {
        model.addAttribute("newsList", newsService.queryList());
        return "newsList";
    }
}
