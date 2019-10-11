package com.forezp.controller;

import com.forezp.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangZhuang on 2019/4/15.
 */
@RestController
/**
 * controller添加hystrix默认设置，service不用再添加
 */
@DefaultProperties(defaultFallback = "defaultFallback")
public class HelloController {
    @Autowired
    HelloService helloService;

    /**
     * http://localhost:8764/hi?name=zhangsan
     */
    @RequestMapping("/hi")
    @HystrixCommand//(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")})
    public String hi(@RequestParam("name") String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return helloService.hiService(name);
    }

    private String defaultFallback(){
        return "哎呀，人太多了，请稍后重试！";
    }
}
