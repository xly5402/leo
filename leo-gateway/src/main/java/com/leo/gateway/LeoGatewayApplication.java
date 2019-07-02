package com.leo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author XieLY
 * @Description //TODO Leo网关
 * @Date 10:37 2019/6/17
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class LeoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeoGatewayApplication.class, args);
    }

}
