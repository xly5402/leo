package com.leo.admin.dao;

import com.leo.admin.model.dto.QueryParam;
import com.leo.common.model.domain.MenuDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author XieLY
 * @Description //TODO 菜单
 * @Date 16:42 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
public interface MenuDAO {
    /**
     * 通过主键获取菜单
     *
     * @param id 主键
     * @return {@link MenuDO}
     */
    MenuDO get(Long id);

    /**
     * 获取用户菜单
     *
     * @param userId 用户ID
     * @return List<MenuDO>
     */
    List<MenuDO> findByUserId(Long userId);

    /**
     * 查询菜单列表
     *
     * @param param 查询参数
     * @return List<MenuDO>
     */
    List<MenuDO> find(QueryParam param);

    /**
     * 查询菜单列表条数
     *
     * @param param 查询参数
     * @return {@link Integer}
     */
    Integer count(QueryParam param);

    /**
     * 新增菜单
     *
     * @param menuDO
     * @return true 成功 false 失败
     */
    Integer save(MenuDO menuDO);

    /**
     * 更新菜单
     *
     * @param menuDO
     * @return true 成功 false 失败
     */
    Integer update(MenuDO menuDO);

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return true 成功 false 失败
     */
    Integer delete(Long id);

    /**
     * 查询角色菜单
     *
     * @param roleKeys 角色键值
     * @return 菜单列表
     */
    List<MenuDO> getRoleMenu(@Param("roleKeys") List<String> roleKeys);
}
