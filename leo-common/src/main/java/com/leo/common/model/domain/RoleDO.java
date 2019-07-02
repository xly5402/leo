package com.leo.common.model.domain;

import lombok.Data;

import java.util.List;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 13:52
 * @Version 1.0
 * @Author: XieLY
 * @Description: 角色
 */
@Data
public class RoleDO extends BaseDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 角色key
     */
    private String key;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;

    /**
     * 菜单ID集合
     */
    private List<Long> menus;
}
