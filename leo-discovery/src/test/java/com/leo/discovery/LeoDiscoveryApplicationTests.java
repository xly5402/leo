package com.leo.discovery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeoDiscoveryApplicationTests {



    @Test
    public void contextLoads() {
        Map<String ,Object> map1 = new HashMap<>();
        Object object = new Object();
        object = "11111";
        map1.put("k1",object);

        map1.get("k2");
        System.out.println("==>"+map1.get("k2"));

    }
    @Test
    public void contextLoads1() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("123");
        list.add(null);
        list.add("456");

        List<String> nullList = new ArrayList<String>(1);

        nullList.add(null);
        list.removeAll(nullList);


        System.out.println("==>"+list);

        System.out.println("==>"+list);
    }

}
