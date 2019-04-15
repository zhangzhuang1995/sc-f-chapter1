package com.forezp.controller;

import com.forezp.feign.FeignServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangZhuang on 2019/4/15.
 */
@RestController
public class FeignController {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    FeignServiceHi feignServiceHi;

    /**
     * localhost:8765/feignHi?name=zhangsan
     * feign整合了ribbon和Hystrix
     */
    @RequestMapping("/feignHi")
    public String sayHi(@RequestParam("name") String name) {
        return feignServiceHi.sayHiFromServiceHi(name);
    }
}
