package com.forezp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author ZhangZhuang
 * @date 2019/10/10
 * @description 鉴权过滤器
 */
@Component
public class AuthPreFilter extends ZuulFilter {

    @Value("${gateway.auth}")
    private Boolean auth;

    @Value("${gateway.auth.whilteList}")
    private String whilteListStr;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        if (auth != null && !auth) {
            return auth;
        }
        //添加鉴权白名单
        RequestContext context = RequestContext.getCurrentContext();
        //全路径的url http://localhost:8769/api-a/hi
        StringBuffer requestURL = context.getRequest().getRequestURL();
        //后缀/api-a/hi
        String requestURI = context.getRequest().getRequestURI();
        if (whilteListStr != null) {
            String[] strings = whilteListStr.split(",");
            List<String> collect = Arrays.stream(strings).collect(Collectors.toList());
            for (String str : collect) {
                if (Pattern.matches(str.replace("*", ".*"), requestURI)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //做鉴权操作
        return null;
    }
}
