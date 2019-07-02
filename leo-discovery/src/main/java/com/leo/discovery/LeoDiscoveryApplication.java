package com.leo.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author XieLY
 * @Description //TODO  注册中心
 * @Date 10:18 2019/6/17
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@EnableEurekaServer
@SpringBootApplication
public class LeoDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeoDiscoveryApplication.class, args);
    }

}
