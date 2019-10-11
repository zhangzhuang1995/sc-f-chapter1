package com.forezp.filter;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhangZhuang
 * @date 2019/10/10
 * @description
 */
@Configuration
public class RibbonConfiguration {
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
