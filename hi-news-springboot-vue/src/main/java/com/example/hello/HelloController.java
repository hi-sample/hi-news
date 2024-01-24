package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IKin <br/>
 * @description demo <br/>
 * @create 2022/10/14 08:21 <br/>
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Hello1111";
    }

}
