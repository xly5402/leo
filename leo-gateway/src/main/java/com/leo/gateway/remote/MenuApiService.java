package com.leo.gateway.remote;

import com.leo.common.model.domain.MenuDO;
import com.leo.gateway.remote.fallback.MenuApiServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/20 11:33
 * @Version 1.0
 * @Author: XieLY
 * @Description:
 */
@FeignClient(name = "leo-admin", fallback = MenuApiServiceFallbackImpl.class)
public interface MenuApiService {
    /**
     * 查询角色菜单
     *
     * @param roleKeys 角色Key
     * @return 菜单列表
     */
    @GetMapping("menu/roleMenu")
    List<MenuDO> findRoleMenu(@RequestParam("roleKeys") List<String> roleKeys);

}
