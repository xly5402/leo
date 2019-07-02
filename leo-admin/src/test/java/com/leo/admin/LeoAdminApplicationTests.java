package com.leo.admin;

import com.leo.admin.controller.BaseController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LeoAdminApplicationTests {

    BaseController baseController;
    @Test
    public void contextLoads() {

        List<String> list = baseController.getRole();
        System.out.println("list==>"+list);
    }



}
