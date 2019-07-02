package com.leo.admin.model.vo;

import com.leo.admin.model.dto.TreeNode;
import com.leo.common.model.domain.DeptDO;
import lombok.Data;

import java.util.Date;
/**
 * @Author XieLY
 * @Description //TODO 部门树
 * @Date 16:45 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Data
public class DeptTreeVO extends TreeNode {
    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sequence;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    public DeptTreeVO(DeptDO deptDO) {
        setId(deptDO.getId());
        setParentId(deptDO.getParentId());
        this.code = deptDO.getCode();
        this.name = deptDO.getName();
        this.sequence = deptDO.getSequence();
        this.status = deptDO.getStatus();
        this.createTime = deptDO.getCreateTime();
        this.modifyTime = deptDO.getModifyTime();
    }
}
