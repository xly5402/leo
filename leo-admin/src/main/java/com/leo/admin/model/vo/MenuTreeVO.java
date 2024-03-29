package com.leo.admin.model.vo;

import com.leo.admin.model.dto.TreeNode;
import com.leo.common.model.domain.MenuDO;
import lombok.Data;

/**
 * @Author XieLY
 * @Description //TODO 菜单树
 * @Date 16:46 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Data
public class MenuTreeVO extends TreeNode {
    /**
     * 名称
     */
    private String name;

    /**
     * 重定向地址，在面包屑中点击会重定向去的地址
     * 当设置 noredirect 的时候该路由在面包屑导航中不可被点击
     */
    private String redirect;

    /**
     * 组件
     */
    private String component;

    /**
     * 类型：1菜单2按钮
     */
    private Integer type;

    /**
     * 前端路径
     */
    private String path;

    /**
     * 资源地址
     */
    private String url;

    /**
     * Http 方法
     */
    private String method;

    /**
     * 权限字符串
     */
    private String permission;

    /**
     * 菜单图标
     */
    private String ico;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;

    public MenuTreeVO(MenuDO menuDO) {
        setId(menuDO.getId());
        setParentId(menuDO.getParentId());
        this.name = menuDO.getName();
        this.component = menuDO.getComponent();
        this.path = menuDO.getPath();
        this.url = menuDO.getUrl();
        this.method = menuDO.getMethod();
        this.redirect = menuDO.getRedirect();
        this.sequence = menuDO.getSequence();
        this.ico = menuDO.getIco();
        this.status = menuDO.getStatus();
        this.permission = menuDO.getPermission();
        this.type = menuDO.getType();
    }
}
