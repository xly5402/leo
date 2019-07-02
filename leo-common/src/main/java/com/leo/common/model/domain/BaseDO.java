package com.leo.common.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 13:52
 * @Version 1.0
 * @Author: XieLY
 * @Description: 基础领域模型
 */

@Data
public abstract class BaseDO implements Serializable {
    /**
     * 创建人ID
     */
    private Long createUser;

    /**
     * 修改人ID
     */
    private Long modifyUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "字符串日期", example = "2018-05-09 12:00:00")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "字符串日期", example = "2018-05-09 12:00:00")
    private Date modifyTime;
}
