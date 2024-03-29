package com.leo.admin.model.dto;

import com.leo.common.model.domain.MenuDO;
import lombok.Data;

/**
 * @Author XieLY
 * @Description //TODO Vue路由器
 * @Date 16:45 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Data
public class VueRouter extends TreeNode {
    /**
     * 路由名称
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 重定向地址，在面包屑中点击会重定向去的地址
     * 当设置 noredirect 的时候该路由在面包屑导航中不可被点击
     */
    private String redirect;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 元信息
     */
    private Meta meta;

    public VueRouter() {
    }

    public VueRouter(MenuDO menuDO) {
        setId(menuDO.getId());
        setParentId(menuDO.getParentId());
        this.name = menuDO.getName();
        this.component = menuDO.getComponent();
        this.path = menuDO.getPath();
        this.redirect = menuDO.getRedirect();
        this.sort = menuDO.getSequence();

        Meta meta = new Meta();
        meta.icon = menuDO.getIco();
        meta.title = menuDO.getName();
        this.meta = meta;
    }

    @Data
    class Meta {
        /**
         * 图标
         */
        private String icon;

        /**
         * 路由标题（菜单显示名称）
         */
        private String title;

        /**
         * 不会被 <keep-alive> 缓存
         */
        private boolean noCache;
    }
}
