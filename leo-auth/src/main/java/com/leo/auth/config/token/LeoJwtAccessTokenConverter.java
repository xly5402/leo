package com.leo.auth.config.token;

import com.leo.common.constant.Constants;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 14:18
 * @Version 1.0
 * @Author: XieLY
 * @Description: JSON Web Token配置
 */

public class LeoJwtAccessTokenConverter extends JwtAccessTokenConverter {
    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        Map<String, Object> stringMap = (Map<String, Object>) super.convertAccessToken(token, authentication);
        stringMap.put("licens", Constants.LEO_LICENSE);
        return stringMap;
    }
}
