package com.leo.common.model.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 13:52
 * @Version 1.0
 * @Author: XieLY
 * @Description: 用户角色
 */
@Data
public class UserRoleDO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;
}
