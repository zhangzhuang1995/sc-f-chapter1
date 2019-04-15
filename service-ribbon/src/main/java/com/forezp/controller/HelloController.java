package com.forezp.controller;

import com.forezp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangZhuang on 2019/4/15.
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam("name") String name) {
        return helloService.hiService(name);
    }
}
