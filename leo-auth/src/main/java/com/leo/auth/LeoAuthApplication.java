package com.leo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author XieLY
 * @Description //TODO 安全模块
 * @Date 12:37 2019/6/17
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class LeoAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeoAuthApplication.class, args);
    }

}
