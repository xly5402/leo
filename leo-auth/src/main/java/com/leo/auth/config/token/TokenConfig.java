package com.leo.auth.config.token;

import com.leo.common.constant.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 14:25
 * @Version 1.0
 * @Author: XieLY
 * @Description: Token凭证配置
 */

@Configuration
public class TokenConfig {
    /**
     * @Author XieLY
     * @Description //TODO 生成token 定制化处理
     * @Date 14:28 2019/6/17
     * @Param
     * @Eamil 540236979@qq.com
     * @return TokenEnhancer
     */
    @Bean
    public TokenEnhancer tokenEnhancer(){
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(1);
            additionalInfo.put("license", Constants.LEO_LICENSE);
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

    /**
     * @Author XieLY
     * @Description //TODO JWT
     * @Date 14:31 2019/6/17
     * @Param
     * @Eamil 540236979@qq.com
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){

        LeoJwtAccessTokenConverter jwtAccessTokenConverter = new LeoJwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(Constants.JWT_SIGN_KEY);
        return jwtAccessTokenConverter;
    }

}
