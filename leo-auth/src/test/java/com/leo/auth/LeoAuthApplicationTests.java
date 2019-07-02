package com.leo.auth;

import com.leo.auth.config.token.TokenConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeoAuthApplicationTests {

    TokenConfig tokenConfig;
    @Test
    public void contextLoads() {
    }
    @Test
    public void getToken() {

//        TokenEnhancer tokenEnhancer = tokenConfig.tokenEnhancer();
//        System.out.println("tokenEnhancer==>"+tokenEnhancer);

        JwtAccessTokenConverter jwtAccessTokenConverter = tokenConfig.jwtAccessTokenConverter();
        System.out.println("jwtAccessTokenConverter==>"+jwtAccessTokenConverter.getJwtClaimsSetVerifier());

    }

}
