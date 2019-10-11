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
     * postman发送 post请求
     * config-client会重新读取配置文件
     *
     * 可以做一个hook，修改配置文件后调用接口，刷新配置
     * /actuator/bus-refresh接口可以指定服务，即使用"destination"参数，
     * http://localhost:8881/actuator/bus-refresh?destination=config-client:**
     * 即刷新服务名为config-client的所有服务。
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${name}")
    String name;

    /**
     * http://localhost:8881/hi
     * config-client从config-server获取了name的属性
     */
    @RequestMapping(value = "/hi")
    public String hi() {
        return name;
    }
}
