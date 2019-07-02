package com.leo.common.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 13:52
 * @Version 1.0
 * @Author: XieLY
 * @Description: 分页模型
 */
@Data
public class Page implements Serializable {
    /**
     * 总条数
     */
    private int total;

    /**
     * 集合
     */
    private List<?> rows;
}
