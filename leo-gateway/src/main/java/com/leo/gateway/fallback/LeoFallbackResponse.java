package com.leo.gateway.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/20 11:22
 * @Version 1.0
 * @Author: XieLY
 * @Description: 服务降级提示
 */

@Slf4j
public class LeoFallbackResponse implements ClientHttpResponse {
    private Throwable cause;
    private String service;
    private String message;

    public LeoFallbackResponse(Throwable cause, String service, String message) {
        this.cause = cause;
        this.service = service;
        this.message = message;
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        //服务不可用
        return HttpStatus.SERVICE_UNAVAILABLE;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        //服务不可用 503
        return HttpStatus.SERVICE_UNAVAILABLE.value();
    }

    @Override
    public String getStatusText() throws IOException {
        //Service Unavailable
        return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
    }

    @Override
    public void close() {

    }

    @Override
    public InputStream getBody() throws IOException {
        if (cause != null && cause.getMessage() != null) {
            log.error("调用:{} 异常：{}", service, cause.getMessage());
            return new ByteArrayInputStream(cause.getMessage().getBytes());
        } else {
            log.error("调用:{} 异常：{}", service, message);
            return new ByteArrayInputStream(message.getBytes());
        }
    }

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        //  设置内容类型  应用JSON
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
