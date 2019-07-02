package com.leo.gateway.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/20 11:34
 * @Version 1.0
 * @Author: XieLY
 * @Description: 鉴权服务
 */
public interface PermissionService {
    /**
     * 判断请求是否有权限
     *
     * @param request        HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
