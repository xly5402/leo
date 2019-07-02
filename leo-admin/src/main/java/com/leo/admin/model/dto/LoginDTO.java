package com.leo.admin.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author XieLY
 * @Description //TODO 登录参数
 * @Date 16:44 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Data
public class LoginDTO {
    /**
     * 用户名
     */
    @NotNull
    private String username;

    /**
     * 密码
     */
    @NotNull
    private String password;

    /**
     * 验证码
     */
    private String captcha;
}
