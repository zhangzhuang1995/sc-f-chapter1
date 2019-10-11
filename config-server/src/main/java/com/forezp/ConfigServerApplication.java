package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication {

	/**
	 * http://localhost:8888/foo/dev
	 * {"name":"foo","profiles":["dev"],"label":null,"version":"0fc8081c507d694b27967e9074127b373d196431","state":null,"propertySources":[]}
	 *
	 * http://localhost:8888/config-client/dev
	 * {"name":"config-client","profiles":["dev"],"label":null,"version":"0fc8081c507d694b27967e9074127b373d196431","state":null,"propertySources":[{"name":"https://github.com/forezp/SpringcloudConfig//respo/config-client-dev.properties","source":{"foo":"foo version 21","democonfigclient.message":"hello spring io"}}]}
	 *
	 * http://localhost:8888/config-client-dev.yml
	 * age: '23'
	 * name: zhangsan-dev
	 * token: '123456789'
	 */

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
