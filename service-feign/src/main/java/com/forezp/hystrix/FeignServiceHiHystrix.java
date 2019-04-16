package com.forezp.hystrix;

import com.forezp.feign.FeignServiceHi;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangZhuang on 2019/4/15.
 */

/**
 * 熔断返回类
 */
@Component
public class FeignServiceHiHystrix implements FeignServiceHi {
    @Override
    public String sayHiFromServiceHi(String name) {
        return "sorry " + name;
    }
}
