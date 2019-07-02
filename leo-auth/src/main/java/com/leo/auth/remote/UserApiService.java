package com.leo.auth.remote;

import com.leo.common.model.domain.RoleDO;
import com.leo.common.model.domain.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 15:00
 * @Version 1.0
 * @Author: XieLY
 * @Description: 远程调用 用户服务
 */
@FeignClient(name = "leo-admin")
public interface UserApiService {
    /**
     * 根据用户名获取用户详情
     *
     * @param username 用户名
     * @return UserDO
     */
    @GetMapping("user/username/{username}")
    UserDO getByUsername(@PathVariable("username") String username);

    /**
     * 获取用户角色详情
     *
     * @param id 用户ID
     * @return UserDO
     */
    @GetMapping("user/{id}/role")
    List<RoleDO> getUserRole(@PathVariable("id") Long id);

}
