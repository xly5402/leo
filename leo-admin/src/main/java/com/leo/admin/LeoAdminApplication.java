package com.leo.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author XieLY
 * @Description //TODO 后端管理平台
 * @Date 12:40 2019/6/17
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@MapperScan("com.leo.admin.dao")
@EnableEurekaClient
@SpringBootApplication
public class LeoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeoAdminApplication.class, args);
    }

}
