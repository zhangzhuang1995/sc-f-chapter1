package com.forezp.feign;

import com.forezp.hystrix.FeignServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ZhangZhuang on 2019/4/15.
 */

/**
 * 定义一个feign接口，通过@FeignClient（“服务名”），来指定调用哪个服务。比如在代码中调用了service-hi服务的“/hi”接口
 */
@FeignClient(value = "service-hi",fallback = FeignServiceHiHystrix.class)
public interface FeignServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromServiceHi(@RequestParam("name") String name);
}
