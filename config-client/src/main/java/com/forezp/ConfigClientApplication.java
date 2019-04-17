package com.forezp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient //如果我们在类路径上具有spring-cloud-starter-netflix-eureka-client依赖关系，则@EnableEurekaClient是可选的。
@RefreshScope
public class ConfigClientApplication {

    /**
     * http://localhost:8881/actuator/bus-refresh
     * config-client会重新读取配置文件
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

//    @Value("${foo}")
//    String foo;
//
//    @Value("${democonfigclient.message}")
//    String message;

    @Value("${name}")
    String name;

    /**
     * http://localhost:8881/hi
     * config-client从config-server获取了foo的属性
     */
    @RequestMapping(value = "/hi")
    public String hi() {
//        return foo + "," + message + "," + label;
        return name;
    }
}
