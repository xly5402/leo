package com.leo.admin.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author XieLY
 * @Description //TODO 查询参数
 * @Date 16:44 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Data
public class QueryParam implements Serializable {
    private static final String ORDER_ASC = "ASC";
    private static final String ORDER_DESC = "DESC";
    /**
     * 查询文本
     */
    private String queryText;

    /**
     * 单页大小
     */
    private Integer limit = 10;

    /**
     * 页码
     */
    private Integer page = 1;

    /**
     * 偏移量
     */
    @JsonIgnore
    private Integer offset;

    /**
     * 排序名称
     */
    private String sort;

    /**
     * 正序 ASC 倒叙 DESC
     */
    private String order = ORDER_ASC;

    public void setOrder(String order) {
        if (ORDER_DESC.equals(order)) {
            order = ORDER_DESC;
        }
    }

    public Integer getOffset() {
        return (page - 1) * limit;
    }
}
