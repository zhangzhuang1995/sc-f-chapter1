package com.forezp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZhangZhuang on 2019/4/15.
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    //@HystrixCommand注解。该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
    //@HystrixCommand(fallbackMethod = "hiError")
    //可以设置超时时间 默认1秒
    //@HystrixCommand(fallbackMethod = "hiError",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi," + name + "，地球找不到你了！";
    }
}
