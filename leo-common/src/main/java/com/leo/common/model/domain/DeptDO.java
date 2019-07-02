package com.leo.common.model.domain;

import lombok.Data;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 13:52
 * @Version 1.0
 * @Author: XieLY
 * @Description: 部门
 */

@Data
public class DeptDO extends BaseDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 父部门ID
     */
    private Long parentId;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 是否已删除
     */
    private Boolean deleted;
}
