package com.leo.gateway.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/20 11:28
 * @Version 1.0
 * @Author: XieLY
 * @Description: 授权模块降级回调
 */

@Component
public class LeoAuthFallbackProvider implements FallbackProvider {
    private static final String SERVICE_NAME = "leo-auth";
    private static final String SERVICE_DISABLE = "服务不可用";

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new LeoFallbackResponse(cause, SERVICE_NAME, SERVICE_DISABLE);
    }

    @Override
    public String getRoute() {
        return SERVICE_NAME;
    }


}
