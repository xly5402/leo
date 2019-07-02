package com.leo.admin.dao;

import com.leo.common.model.domain.UserRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author XieLY
 * @Description //TODO 用户角色
 * @Date 16:43 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
public interface UserRoleDAO {

    /**
     * 获取用户角色ID集合
     *
     * @param userId 用户主键
     * @return List<Long>
     */
    List<Long> findRoleIdsByUserId(Long userId);

    /**
     * 删除用户角色关系
     *
     * @param userId 用户主键
     * @return 受影响行数
     */
    Integer deleteByUserId(Long userId);

    /**
     * 批量保存用户角色关系
     *
     * @param userRoles 用户角色
     * @return 受影响行数
     */
    Integer batchSave(@Param("userRoles") List<UserRoleDO> userRoles);
}
