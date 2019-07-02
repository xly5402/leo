package com.leo.admin.service;

import com.leo.common.model.domain.RoleMenuDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XieLY
 * @Description //TODO
 * @Date 16:54 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Service
public interface RoleMenuService {

    /**
     * 获取角色菜单ID集合
     *
     * @param roleId 角色主键
     * @return List<Long>
     */
    List<Long> findMenuIdsByRoleId(Long roleId);

    /**
     * 删除角色菜单关系
     *
     * @param roleId 角色主键
     * @return 受影响行数
     */
    Integer deleteByRoleId(Long roleId);

    /**
     * 批量保存角色菜单关系
     *
     * @param roleMenus 角色菜单
     * @return 受影响行数
     */
    Integer batchSave(List<RoleMenuDO> roleMenus);
}
