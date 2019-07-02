package com.leo.admin.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author XieLY
 * @Description //TODO 树节点
 * @Date 16:44 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Data
public class TreeNode implements Serializable {
    private long id;
    private long parentId;
    /**
     * 子节点
     */
    private List<TreeNode> children = new ArrayList<>();

    public void addChild(TreeNode node) {
        children.add(node);
    }
}
